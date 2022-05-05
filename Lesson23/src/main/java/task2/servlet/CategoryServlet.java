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

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        List<Product> productsCategories = getProductByCategoryId(id);
        req.setAttribute("productList", productsCategories);
        req.getServletContext().getRequestDispatcher("/category.jsp").forward(req, resp);
    }

    private List<Product> getProductByCategoryId(int id) {
        List<Product> productList = new ArrayList<>();

        switch (id) {
            case 1 -> {
                Product samsung = new Product(1, "Samsung_A51", "Лучший мобильный телефон серии A", "samsung.jpg", 123);
                Product iphone = new Product(2, "Iphone_X", "В качестве новинки улучшенная камера", "iphone.jpg", 453);
                Product xiaomi = new Product(3, "Xiaomi_Poco", "Увеличенная емкость батареи", "xiaomi.jpg", 233);

                productList.add(samsung);
                productList.add(iphone);
                productList.add(xiaomi);
            }
            case 2 -> {
                Product asus = new Product(4, "Asus", "Лучший ноутбук серии A", " ", 121);
                Product macBook = new Product(5, "MacBook", "В качестве новинки улучшенная камера", " ", 154);
                Product xiaomi = new Product(6, "Xiaomi", "Увеличенная емкость батареи", " ", 141);

                productList.add(asus);
                productList.add(macBook);
                productList.add(xiaomi);
            }
            case 3 -> {
                Product samsung = new Product(7, "Samsung", "Лучший навигатор серии A", " ", 124);
                Product panasonic = new Product(8, "Panasonic", "В качестве новинки улучшенная камера", " ", 45);
                Product xiaomi = new Product(9, "Xiaomi", "Увеличенная емкость батареи", " ", 24);

                productList.add(samsung);
                productList.add(panasonic);
                productList.add(xiaomi);
            }
            case 4 -> {
                Product samsung = new Product(10, "Fridge_1", "Лучший холодильник серии A", " ", 124);
                Product indesit = new Product(11, "Fridge_2", "В качестве новинки улучшенная морозильная камера", " ", 46);
                Product xiaomi = new Product(12, "Fridge_3", "Увеличенная емкость батареи", " ", 67);

                productList.add(samsung);
                productList.add(indesit);
                productList.add(xiaomi);
            }
            case 5 -> {
                Product bmw = new Product(13, "BMW", "Лучший двигатель серии A", " ", 121);
                Product jaguar = new Product(14, "Jaguar", "В качестве новинки улучшенная коробка передач", " ", 111);
                Product audi = new Product(15, "Audi", "Увеличенная емкость батареи", " ", 232);

                productList.add(bmw);
                productList.add(jaguar);
                productList.add(audi);
            }
            case 6 -> {
                Product samsung = new Product(16, "Photo_1", "Лучшая камера серии A", " ", 111);
                Product panasonic = new Product(17, "Photo_2", "В качестве новинки улучшенная камера", " ", 124);
                Product xiaomi = new Product(18, "Photo_3", "Увеличенная емкость батареи", " ", 235);

                productList.add(samsung);
                productList.add(panasonic);
                productList.add(xiaomi);
            }
        }
        return productList;
    }
}
