package by.teachmeskills.eshop.controllers;

import by.teachmeskills.eshop.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static by.teachmeskills.eshop.utils.EshopConstants.SEARCH_PARAM;

@RestController
@RequestMapping("/search")
public class SearchController {
    private final ProductService productService;


    public SearchController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ModelAndView openSearchPage(String param) {
        return productService.getProductsBySearchRequest(param);
    }

    @PostMapping
    public ModelAndView getResult(@RequestParam(SEARCH_PARAM) String searchParam) {
        return productService.getProductsBySearchRequest(searchParam);
    }
}