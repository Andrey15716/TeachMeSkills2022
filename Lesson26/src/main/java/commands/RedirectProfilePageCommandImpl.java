package commands;

import entities.Order;
import entities.Product;
import entities.User;
import exceptions.CommandException;
import exceptions.RequestParamNullException;
import repositories.OrderRepository;
import repositories.ProductRepository;
import repositories.impl.OrderRepositoryImpl;
import repositories.impl.ProductRepositoryImpl;
import utils.PagesPathEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import static utils.RequestParamsEnum.LOGGED_IN_USER;
import static utils.RequestParamsEnum.USER_ORDERS;

public class RedirectProfilePageCommandImpl implements BaseCommand {
    private final OrderRepository orderRepository = new OrderRepositoryImpl();
    private final ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException, RequestParamNullException {
        HttpSession session = request.getSession();
        User userLogged = (User) session.getAttribute(LOGGED_IN_USER.getValue());
        int userId = userLogged.getId();
        List<Order> userOrders = new ArrayList<>();
        List<Integer> ordersIds = orderRepository.getAllOrdersIdsByUserId(userId);
        for (Integer ordersId : ordersIds) {
            List<Product> orderProducts = productRepository.getAllProductsByOrderId(ordersId);
            Order order = orderRepository.getOrderById(ordersId);
            order.setProductList(orderProducts);
            userOrders.add(order);
        }
        request.setAttribute(USER_ORDERS.getValue(), userOrders);
        request.setAttribute(LOGGED_IN_USER.getValue(), userLogged);
        return PagesPathEnum.PROFILE_PAGE.getPath();
    }
}