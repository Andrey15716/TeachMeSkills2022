package utils;

public enum CommandsEnum {
    HOME_PAGE_COMMAND("start_page"),
    SIGN_IN_COMMAND("sign-in"),
    CATEGORY_PAGE_COMMAND("category-redirect"),
    REDIRECT_SHOPPING_CART_COMMAND("redirect-to-shopping-cart"),
    REDIRECT_PRODUCT_COMMAND("product-redirect"),
    REGISTRATION_COMMAND("registration"),
    ORDER_COMMAND("order"),
    ADD_PRODUCT_TO_CART_COMMAND("add-product-to-cart"),
    SEARCH_COMMAND("search"),
    CONFIRM_REGISTRATION_COMMAND("confirmRegistration"),
    REDIRECT_TO_PROFILE_COMMAND("redirect-to-profile");

    private final String command;

    CommandsEnum(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
