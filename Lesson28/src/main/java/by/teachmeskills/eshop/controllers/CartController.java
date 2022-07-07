package by.teachmeskills.eshop.controllers;

import by.teachmeskills.eshop.entities.Cart;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.services.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import static by.teachmeskills.eshop.utils.EshopConstants.*;

@RestController
@SessionAttributes({SHOPPING_CART})
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/add")
    public ModelAndView addProductToCart(@RequestParam(PRODUCT_ID_PARAM) int productId, @ModelAttribute(SHOPPING_CART) Cart shopCart) {
        return cartService.addProductToCart(productId, shopCart);
    }

    @GetMapping("/buy")
    public ModelAndView buyProduct(@ModelAttribute(SHOPPING_CART) Cart shopCart, @SessionAttribute(USER) User user) {
        return cartService.buyProduct(shopCart, user);
    }

    @ModelAttribute(SHOPPING_CART)
    public Cart shoppingCart() {
        return new Cart();
    }
}