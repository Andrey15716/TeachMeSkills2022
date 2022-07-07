package by.teachmeskills.eshop.controllers;

import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.services.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static by.teachmeskills.eshop.utils.EshopConstants.USER;
import static by.teachmeskills.eshop.utils.PagesPathEnum.REGISTRATION_PAGE;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView openRegistrationPage() {
        return new ModelAndView(REGISTRATION_PAGE.getPath());
    }

    @PostMapping
    public ModelAndView login(@ModelAttribute(USER) User user) {
        return userService.addNewUser(user);
    }

    @ModelAttribute(USER)
    public User setUpUserForm() {
        return new User();
    }
}