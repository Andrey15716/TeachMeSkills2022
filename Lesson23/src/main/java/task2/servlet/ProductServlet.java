package task2.servlet;

import task2.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        List<Product> productsById = getProductById(id);
        req.setAttribute("productsById", productsById);
        req.getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);

    }

    private List<Product> getProductById(int id) {
        List<Product> productListById = new ArrayList<>();

        switch (id) {
            case 1 -> {
                Product samsung = new Product(1, "Samsung_A51", "Лучший мобильный телефон серии A", "samsung.jpg", 123);
                productListById.add(samsung);
            }
            case 2 -> {
                Product iphone = new Product(2, "Iphone_X", "В качестве новинки улучшенная камера", "iphone.jpg", 453);
                productListById.add(iphone);
            }
            case 3 -> {
                Product xiaomi = new Product(3, "Xiaomi_Poco", "Увеличенная емкость батареи", "xiaomi.jpg", 233);
                productListById.add(xiaomi);
            }
            case 4 -> {
                Product asus = new Product(4, "Asus", "Лучший ноутбук серии A", " ", 121);
                productListById.add(asus);
            }
            case 5 -> {
                Product macBook = new Product(5, "MacBook", "В качестве новинки улучшенная камера", " ", 154);
                productListById.add(macBook);
            }
            case 6 -> {
                Product xiaomi = new Product(6, "Xiaomi", "Увеличенная емкость батареи", " ", 141);
                productListById.add(xiaomi);
            }
            case 7 -> {
                Product samsung = new Product(7, "Samsung", "Лучший навигатор серии A", " ", 124);
                productListById.add(samsung);
            }
            case 8 -> {
                Product panasonic = new Product(8, "Panasonic", "В качестве новинки улучшенная камера", " ", 45);
                productListById.add(panasonic);
            }
            case 9 -> {
                Product xiaomi = new Product(9, "Xiaomi", "Увеличенная емкость батареи", " ", 24);
                productListById.add(xiaomi);
            }
            case 10 -> {
                Product samsung = new Product(10, "Fridge_1", "Лучший холодильник серии A", " ", 124);
                productListById.add(samsung);
            }
            case 11 -> {
                Product indesit = new Product(11, "Fridge_2", "В качестве новинки улучшенная морозильная камера", " ", 46);
                productListById.add(indesit);
            }
            case 12 -> {
                Product xiaomi = new Product(12, "Fridge_3", "Увеличенная емкость батареи", " ", 67);
                productListById.add(xiaomi);
            }
            case 13 -> {
                Product bmw = new Product(13, "BMW", "Лучший двигатель серии A", " ", 121);
                productListById.add(bmw);
            }
            case 14 -> {
                Product jaguar = new Product(14, "Jaguar", "В качестве новинки улучшенная коробка передач", " ", 111);
                productListById.add(jaguar);
            }
            case 15 -> {
                Product audi = new Product(15, "Audi", "Увеличенная емкость батареи", " ", 232);
                productListById.add(audi);
            }
            case 16 -> {
                Product samsung = new Product(16, "Photo_1", "Лучшая камера серии A", " ", 111);
                productListById.add(samsung);
            }
            case 17 -> {
                Product panasonic = new Product(17, "Photo_2", "В качестве новинки улучшенная камера", " ", 124);
                productListById.add(panasonic);
            }
            case 18 -> {
                Product xiaomi = new Product(18, "Photo_3", "Увеличенная емкость батареи", " ", 235);
                productListById.add(xiaomi);
            }
        }
        return productListById;
    }
}
