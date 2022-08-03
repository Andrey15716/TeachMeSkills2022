package by.teachmeskills.eshop.controllers;

import by.teachmeskills.eshop.entities.Category;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.services.CategoryService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static by.teachmeskills.eshop.utils.EshopConstants.USER;
import static by.teachmeskills.eshop.utils.PagesPathEnum.HOME_PAGE;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.CATEGORIES_PARAM;

@RestController
@RequestMapping("/home")
public class HomeController {
    private final CategoryService categoryService;

    public HomeController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ModelAndView getHomePage(@SessionAttribute(USER)User user) {
        ModelMap model = new ModelMap();
        List<Category> categoriesList = categoryService.read();
        model.addAttribute(CATEGORIES_PARAM.getValue(), categoriesList);
        return new ModelAndView(HOME_PAGE.getPath(), model);
    }
}