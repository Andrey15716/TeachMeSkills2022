package commands;

import entities.Product;
import exceptions.CommandException;
import exceptions.RequestParamNullException;
import repositories.CategoryRepository;
import repositories.ProductRepository;
import repositories.impl.CategoryRepositoryImpl;
import repositories.impl.ProductRepositoryImpl;
import utils.PagesPathEnum;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static utils.RequestParamsEnum.CATEGORY;
import static utils.RequestParamsEnum.CATEGORY_ID;
import static utils.RequestParamsEnum.CATEGORY_NAME;

public class CategoryRedirectCommand implements BaseCommand {
    private final CategoryRepository categoryRepository = new CategoryRepositoryImpl();
    private final ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException, RequestParamNullException {
        int id = Integer.parseInt(request.getParameter(CATEGORY_ID.getValue()));
        List<Product> products = productRepository.getAllProductsByCategoryId(id);
        request.setAttribute(CATEGORY_NAME.getValue(), categoryRepository.getCategoryNameByID(id));
        request.setAttribute(CATEGORY.getValue(), products);
        return PagesPathEnum.CATEGORY_PAGE.getPath();
    }
}