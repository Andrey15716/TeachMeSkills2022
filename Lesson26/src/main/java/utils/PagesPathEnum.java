package utils;

public enum PagesPathEnum {
    HOME_PAGE("home.jsp"),
    SIGN_IN_PAGE("signing.jsp"),
    PRODUCT_PAGE("product.jsp"),
    CATEGORY_PAGE("category.jsp"),
    CART_PAGE("cart.jsp"),
    SEARCH_PAGE("search.jsp"),
    REGISTRATION_PAGE("registration.jsp"),
    REGISTRATION_SUCCESS("registration_success.jsp"),
    PROFILE_PAGE("profile.jsp"),
    ORDER_PAGE("orders.jsp");

    private final String path;

    PagesPathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}