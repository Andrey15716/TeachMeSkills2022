package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import utils.CartDAO;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
@ToString
public class Cart {
    private static Map<Product, Integer> products;

    public Cart() {
        products = new LinkedHashMap<>();
    }

    public static Map<Product, Integer> getProducts() {
        return products;
    }

    public static void addProduct(Product product) {
        CartDAO.addProducts(product);
    }
}