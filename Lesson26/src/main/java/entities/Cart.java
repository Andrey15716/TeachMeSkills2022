package entities;

import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Setter
public class Cart {
    private Map<Integer, Product> products;
    private int totalPrice;
    private int quantity;

    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public Cart() {
        this.products = new HashMap<>();
    }

    public static Cart checkCart(Object o) {
        Cart cart;
        if (Optional.ofNullable(o).isPresent()) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }
        return cart;
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
        totalPrice += product.getPrice();
    }

    public void clearCart() {
        products.clear();
    }

    public Cart(int totalPrice) {
        this.totalPrice = totalPrice * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;
        Cart cart = (Cart) o;
        return products.equals(cart.products);
    }

    @Override
    public int hashCode() {
        return products.hashCode();
    }
}