package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.entities.Category;
import by.teachmeskills.eshop.entities.Order;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.repositories.OrderRepository;
import by.teachmeskills.eshop.repositories.ProductRepository;
import by.teachmeskills.eshop.repositories.UserRepository;
import by.teachmeskills.eshop.services.CategoryService;
import by.teachmeskills.eshop.services.UserService;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.teachmeskills.eshop.utils.PagesPathEnum.*;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.*;

@Repository
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final OrderRepository orderRepository;

    public UserServiceImpl(UserRepository userRepository, ProductRepository productRepository, CategoryService categoryService, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.orderRepository = orderRepository;
    }

    @Override
    public User create(User entity) {
        return userRepository.addUser(entity);
    }

    @Override
    public List<User> read() {
        return userRepository.read();
    }

    @Override
    public User update(User entity) {
        return userRepository.update(entity);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public ModelAndView authenticate(User user) {
        ModelAndView modelAndView = new ModelAndView();
        if (Optional.ofNullable(user).isPresent()
                && Optional.ofNullable(user.getName()).isPresent()
                && Optional.ofNullable(user.getPassword()).isPresent()) {
            User loggedUser = userRepository.getUserByLoginAndPass(user.getName(), user.getPassword());
            if (Optional.ofNullable(loggedUser).isPresent()) {
                ModelMap modelMap = new ModelMap();
                List<Category> categoriesList = categoryService.read();
                modelMap.addAttribute(CATEGORIES_PARAM.getValue(), categoriesList);
                modelAndView.setViewName(HOME_PAGE.getPath());
                modelAndView.addAllObjects(modelMap);
            } else {
                modelAndView.setViewName(SIGN_IN_PAGE.getPath());
            }
        }
        return modelAndView;
    }

    @Override
    public ModelAndView addNewUser(User user) {
        ModelAndView modelAndView = new ModelAndView();
        ModelMap modelMap = new ModelMap();
        String username = user.getName();
        modelMap.addAttribute(LOGIN_PARAM.getValue(), username);
        modelAndView.addObject(modelMap);
        create(user);
        modelAndView.setViewName(REGISTRATION_SUCCESS.getPath());
        return modelAndView;
    }

    @Override
    public ModelAndView getProfileAccount(User user) {
        ModelAndView modelAndView = new ModelAndView();
        User loggedInUser = userRepository.getUserByLoginAndPass(user.getName(), user.getPassword());
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute(LOGGED_IN_USER_PARAM.getValue(), loggedInUser);
        int userId = loggedInUser.getId();
        user.setId(userId);
        List<Order> userOrders = new ArrayList<>();
        List<Integer> ordersIds = orderRepository.getAllOrdersIdsByUserId(userId);
        for (Integer ordersId : ordersIds) {
            List<Product> orderProducts = productRepository.getAllProductsByOrderId(ordersId);
            Order order = orderRepository.getOrderById(ordersId);
            order.setProductList(orderProducts);
            userOrders.add(order);
        }
        modelMap.addAttribute(USER_ORDERS_PARAM.getValue(), userOrders);
        modelAndView.setViewName(PROFILE_PAGE.getPath());
        modelAndView.addAllObjects(modelMap);
        return modelAndView;
    }
}