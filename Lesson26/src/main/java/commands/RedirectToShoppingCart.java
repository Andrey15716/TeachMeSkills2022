package commands;

import entities.Cart;
import exceptions.CommandException;
import exceptions.RequestParamNullException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Objects;

import static utils.PagesPathEnum.CART_PAGE;
import static utils.RequestParamsEnum.SHOPPING_CART;
import static utils.RequestParamsEnum.SHOPPING_CART_PRODUCTS;

public class RedirectToShoppingCart implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException, RequestParamNullException {
        HttpSession httpSession = request.getSession();
        Cart cart = (Cart) httpSession.getAttribute(SHOPPING_CART.getValue());
        request.setAttribute(SHOPPING_CART_PRODUCTS.getValue(), Objects.requireNonNullElse(cart, ""));
        return CART_PAGE.getPath();
    }
}