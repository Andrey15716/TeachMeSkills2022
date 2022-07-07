package commands;

import entities.Product;
import exceptions.CommandException;
import exceptions.RequestParamNullException;
import repositories.ProductRepository;
import repositories.impl.ProductRepositoryImpl;
import utils.PagesPathEnum;

import javax.servlet.http.HttpServletRequest;

import static utils.RequestParamsEnum.PRODUCT;
import static utils.RequestParamsEnum.PRODUCT_ID;

public class RedirectProductPageCommandImpl implements BaseCommand {
    private final ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException, RequestParamNullException {
        int id = Integer.parseInt(request.getParameter(PRODUCT_ID.getValue()));
        Product product = productRepository.getProductById(id);
        request.setAttribute(PRODUCT.getValue(), product);
        return PagesPathEnum.PRODUCT_PAGE.getPath();
    }
}