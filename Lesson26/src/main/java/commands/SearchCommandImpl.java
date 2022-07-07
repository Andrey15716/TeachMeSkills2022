package commands;

import entities.Product;
import exceptions.CommandException;
import exceptions.RequestParamNullException;
import repositories.ProductRepository;
import repositories.impl.ProductRepositoryImpl;
import utils.PagesPathEnum;
import utils.RequestParamsEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static utils.RequestParamsEnum.SEARCH_RESULT;

public class SearchCommandImpl implements BaseCommand {
    private final ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException, RequestParamNullException {
        List<Product> requestProducts;
        String searchParameter = request.getParameter(RequestParamsEnum.SEARCH_PARAM.getValue());
        if (Optional.ofNullable(searchParameter).isEmpty()) {
            return PagesPathEnum.SEARCH_PAGE.getPath();
        } else {
            List<Product> productListResult = productRepository.getProductsBySearchRequest(searchParameter);
            requestProducts = productListResult.stream().filter(p -> p.getName().contains(searchParameter)).collect(Collectors.toList());
        }
        request.setAttribute(SEARCH_RESULT.getValue(), requestProducts);
        return PagesPathEnum.SEARCH_PAGE.getPath();
    }
}