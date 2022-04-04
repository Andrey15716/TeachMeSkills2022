package shop;

import shop.model.Products;
import shop.model.Users;
import shop.utils.CRUDUtils;

public class Application {
    public static void main(String[] args) {
        Products products = new Products(6, "ah", "ashh", "yes", "124", "111");
        Users users = new Users(4, "Mike", "Mikson");
        System.out.println("All products");
        System.out.println(CRUDUtils.getAllProducts());
        System.out.println("All Users");
        System.out.println(CRUDUtils.getAllUsers());
        System.out.println("Save product");
        System.out.println(CRUDUtils.saveProducts(products));
        System.out.println("Update product");
        System.out.println(CRUDUtils.updateProducts(1, "123", "yes", "222"));
        System.out.println("Delete product");
        System.out.println(CRUDUtils.deleteProducts(3));
        System.out.println("Save user");
        System.out.println(CRUDUtils.saveUsers(users));
    }
}
