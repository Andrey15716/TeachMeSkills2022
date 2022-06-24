package commands;

import entities.Cart;
import entities.Category;
import entities.User;
import exceptions.CommandException;
import exceptions.RequestParamNullException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repositories.CategoryRepository;
import repositories.UserRepository;
import repositories.impl.CategoryRepositoryImpl;
import repositories.impl.UserRepositoryImpl;
import utils.PagesPathEnum;
import utils.RequestParamsEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.Optional;

import static utils.HttpRequestParamValidator.validateParamNotNull;
import static utils.RequestParamsEnum.CATEGORIES;
import static utils.RequestParamsEnum.LOGGED_IN_USER;
import static utils.RequestParamsEnum.SHOPPING_CART;

public class SigningCommandImpl implements BaseCommand {

    private final static Logger log = LoggerFactory.getLogger(SigningCommandImpl.class);
    private final CategoryRepository categoryRepository = new CategoryRepositoryImpl();
    private final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException, RequestParamNullException {
        String login = request.getParameter(RequestParamsEnum.LOGIN.getValue());
        String pass = request.getParameter(RequestParamsEnum.PASSWORD.getValue());

        validateParamNotNull(login);
        validateParamNotNull(pass);

        User user = new User(login, pass);
        return checkReceivedUser(user, request);
    }

    private String checkReceivedUser(User user, HttpServletRequest request) {
        String login = request.getParameter(RequestParamsEnum.LOGIN.getValue());
        String password = request.getParameter(RequestParamsEnum.PASSWORD.getValue());
        Optional<User> userOptional = userRepository.getUserByLoginAndPass(login, password);
        if (userOptional.isPresent() && user != null) {
            User loggedInUser = userOptional.get();
            request.getSession().setAttribute(RequestParamsEnum.LOGIN.getValue(), user);
            List<Category> categories = categoryRepository.getAllCategories();
            HttpSession session = request.getSession();
            Cart cart = new Cart();
            session.setAttribute(CATEGORIES.getValue(), categories);
            session.setAttribute(LOGGED_IN_USER.getValue(), loggedInUser);
            session.setAttribute(SHOPPING_CART.getValue(), cart);
            int userId = loggedInUser.getId();
            log.info("user with id = " + userId + " logged in");
            return PagesPathEnum.HOME_PAGE.getPath();
        } else {
            return PagesPathEnum.SIGN_IN_PAGE.getPath();
        }
    }
}