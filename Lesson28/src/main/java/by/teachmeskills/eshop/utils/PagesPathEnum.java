package by.teachmeskills.eshop.utils;

public enum PagesPathEnum {
    HOME_PAGE("home"),
    SIGN_IN_PAGE("signing"),
    PRODUCT_PAGE("product"),
    CATEGORY_PAGE("category"),
    CART_PAGE("cart"),
    SEARCH_PAGE("search"),
    REGISTRATION_PAGE("registration"),
    REGISTRATION_SUCCESS("registration_success"),
    PROFILE_PAGE("profile"),
    ORDER_PAGE("orders");

    private final String path;

    PagesPathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}