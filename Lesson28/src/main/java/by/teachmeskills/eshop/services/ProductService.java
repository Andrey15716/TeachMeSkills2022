package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.entities.Product;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface ProductService extends BaseServices<Product> {
    List<Product> getAllProductsByCategoryId(int categoryId);

    ModelAndView getProductsBySearchRequest(String param);

    ModelAndView getProductById(int id);
}