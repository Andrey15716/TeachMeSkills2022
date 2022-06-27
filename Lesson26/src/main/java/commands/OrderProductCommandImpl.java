package commands;

import entities.Cart;
import entities.Order;
import entities.Product;
import entities.User;
import exceptions.CommandException;
import exceptions.RequestParamNullException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repositories.OrderRepository;
import repositories.impl.OrderRepositoryImpl;
import utils.PagesPathEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.time.LocalDate;
import java.util.List;

import static utils.RequestParamsEnum.SHOPPING_CART;
import static utils.RequestParamsEnum.LOGGED_IN_USER;
import static utils.RequestParamsEnum.SHOPPING_CART_PRODUCTS;
import static utils.RequestParamsEnum.ORDER_ID;
import static utils.RequestParamsEnum.PRICE_ORDER;

public class OrderProductCommandImpl implements BaseCommand {
    private final OrderRepository orderRepository = new OrderRepositoryImpl();
    private final static Logger log = LoggerFactory.getLogger(OrderProductCommandImpl.class);


    @Override
    public String execute(HttpServletRequest request) throws CommandException, RequestParamNullException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute(SHOPPING_CART.getValue());
        List<Product> products = cart.getProducts();
        int priceOrder = cart.getTotalPrice();
        LocalDate date = LocalDate.now();
        User loggedInUser = (User) session.getAttribute(LOGGED_IN_USER.getValue());
        Order order = new Order(loggedInUser.getId(), date, priceOrder, products);
        Order createdOrder = orderRepository.create(order);
        cart.clearCart();
        cart.setTotalPrice(0);
        session.setAttribute(SHOPPING_CART_PRODUCTS.getValue(), cart);
        request.setAttribute(ORDER_ID.getValue(), createdOrder.getId());
        request.setAttribute(PRICE_ORDER.getValue(), priceOrder);
        int userId = loggedInUser.getId();
        log.info("User with id = " + userId + " purchased order with id = " + createdOrder.getId());
        return PagesPathEnum.ORDER_PAGE.getPath();
    }
}