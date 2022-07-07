package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.repositories.ProductRepository;
import by.teachmeskills.eshop.services.ProductService;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

import static by.teachmeskills.eshop.utils.PagesPathEnum.PRODUCT_PAGE;
import static by.teachmeskills.eshop.utils.PagesPathEnum.SEARCH_PAGE;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.PRODUCT_PARAM;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.SEARCH_RESULT_PARAM;

@Repository
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product entity) {
        return productRepository.create(entity);
    }

    @Override
    public List<Product> read() {
        return productRepository.read();
    }

    @Override
    public Product update(Product entity) {
        return productRepository.update(entity);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> getAllProductsByCategoryId(int categoryId) {
        return productRepository.getAllProductsByCategoryId(categoryId);
    }

    @Override
    public ModelAndView getProductsBySearchRequest(String param) {
        ModelMap modelMap = new ModelMap();
        List<Product> productListResult = productRepository.getProductsBySearchRequest(param);
        modelMap.addAttribute(SEARCH_RESULT_PARAM.getValue(), productListResult);
        return new ModelAndView(SEARCH_PAGE.getPath(), modelMap);
    }

    @Override
    public ModelAndView getProductById(int id) {
        ModelMap modelMap = new ModelMap();
        Product product = productRepository.getProductById(id);
        if (Optional.ofNullable(product).isPresent()) {
            modelMap.addAttribute(PRODUCT_PARAM.getValue(), product);
        }
        return new ModelAndView(PRODUCT_PAGE.getPath(), modelMap);
    }
}