package commands;

import entities.Cart;
import entities.Product;
import entities.User;
import exceptions.CommandException;
import org.slf4j.LoggerFactory;
import repositories.ProductRepository;
import repositories.impl.ProductRepositoryImpl;
import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static utils.PagesPathEnum.PRODUCT_PAGE;
import static utils.RequestParamsEnum.PRODUCT_ID;
import static utils.RequestParamsEnum.SHOPPING_CART;
import static utils.RequestParamsEnum.PRODUCT;
import static utils.RequestParamsEnum.LOGGED_IN_USER;

public class AddProductToCartCommandImpl implements BaseCommand {
    private final static Logger log = LoggerFactory.getLogger(AddProductToCartCommandImpl.class);
    private final ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        int productId = Integer.parseInt(request.getParameter(PRODUCT_ID.getValue()));
        Product product = productRepository.getProductById(productId);
        Object objCart = session.getAttribute(SHOPPING_CART.getValue());
        Cart cart = Cart.checkCart(objCart);
        cart.addProduct(product);
        session.setAttribute(SHOPPING_CART.getValue(), cart);
        request.setAttribute(PRODUCT.getValue(), product);
        User loggedInUser = (User) session.getAttribute(LOGGED_IN_USER.getValue());
        int userId = loggedInUser.getId();

        log.info("user with id = " + userId + " added to shopping cart product with id " + productId);
        return PRODUCT_PAGE.getPath();
    }
}