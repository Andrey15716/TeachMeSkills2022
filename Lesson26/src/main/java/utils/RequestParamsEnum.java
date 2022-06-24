package utils;

public enum RequestParamsEnum {
    LOGIN("username"),
    PASSWORD("password"),
    NAME("name"),
    SURNAME("surname"),
    DATE_BORN("dateBorn"),
    COMMAND("command"),
    SHOPPING_CART("cart"),
    CATEGORY("category"),
    PRODUCT("product"),
    SHOPPING_CART_PRODUCTS("cartProductsList"),
    PRODUCT_ID("product_id"),
    CATEGORIES("categories"),
    LOGGED_IN_USER("loggedInUser"),
    CATEGORY_ID("category_id"),
    ORDER_ID("order_id"),
    PRICE_ORDER("priceOrder"),
    USER_ORDERS("userOrders"),
    SEARCH_PARAM("searchParameter"),
    SEARCH_RESULT("search_result"),
    CATEGORY_NAME("categoryName");

    private final String value;

    RequestParamsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}