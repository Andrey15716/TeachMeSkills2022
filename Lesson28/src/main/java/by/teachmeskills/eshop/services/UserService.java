package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.entities.User;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public interface UserService extends BaseServices<User> {
    ModelAndView authenticate(User user);

    ModelAndView addNewUser(User user);

    ModelAndView getProfileAccount(User user);
}
