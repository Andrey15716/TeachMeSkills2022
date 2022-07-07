package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.entities.Cart;
import by.teachmeskills.eshop.entities.Order;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.repositories.OrderRepository;
import by.teachmeskills.eshop.repositories.ProductRepository;
import by.teachmeskills.eshop.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

import static by.teachmeskills.eshop.utils.PagesPathEnum.CART_PAGE;
import static by.teachmeskills.eshop.utils.PagesPathEnum.ORDER_PAGE;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.ORDER_ID_PARAM;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.PRICE_ORDER_PARAM;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.PRODUCT_PARAM;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.SHOPPING_CART_PARAM;

@Service
public class CartService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public CartService(ProductRepository productRepository, OrderRepository orderRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public ModelAndView addProductToCart(int productId, Cart shopCart) {
        ModelMap modelParams = new ModelMap();

        Product product = productRepository.getProductById(productId);
        shopCart.addProduct(product);
        modelParams.addAttribute(PRODUCT_PARAM.getValue(), product);
        modelParams.addAttribute(SHOPPING_CART_PARAM.getValue(), shopCart);
        return new ModelAndView(CART_PAGE.getPath(), modelParams);
    }

    public ModelAndView buyProduct(Cart shopCart, User user) {
        ModelMap modelMap = new ModelMap();

        List<Product> products = shopCart.getProducts();
        int priceOrder = shopCart.getTotalPrice();
        LocalDate date = LocalDate.now();
        User loggedInUser = userRepository.getUserByLoginAndPass(user.getName(), user.getPassword());
        int userId = loggedInUser.getId();
        user.setId(userId);
        Order order = new Order(userId, date, priceOrder, products);
        Order createdOrder = orderRepository.create(order);
        modelMap.addAttribute(PRICE_ORDER_PARAM.getValue(), priceOrder);
        modelMap.addAttribute(ORDER_ID_PARAM.getValue(), createdOrder.getId());
        shopCart.clearCart();
        shopCart.setTotalPrice(0);
        return new ModelAndView(ORDER_PAGE.getPath(), modelMap);
    }
}