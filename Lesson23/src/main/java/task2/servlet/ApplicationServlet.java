package task2.servlet;

import task2.exceptions.RequestParamNullException;
import task2.model.Category;
import task2.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static task2.utils.HttpRequestParamValidator.validateParamNotNull;

@WebServlet("/login")
public class ApplicationServlet extends HttpServlet {

    private static final String ADMIN_LOGIN = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("signing.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("username");
        String pass = req.getParameter("password");
        User user = null;

        try {
            validateParamNotNull(login);
            validateParamNotNull(pass);
            user = new User(ADMIN_LOGIN, ADMIN_PASSWORD);

        } catch (RequestParamNullException e) {
            System.out.println(e.getMessage());
        }

        RequestDispatcher rd = req.getRequestDispatcher(checkReceivedUser(user, req));
        rd.forward(req, resp);

    }

    private String checkReceivedUser(User user, HttpServletRequest request) {
        if (user != null
                && request.getParameter("username").equals(ADMIN_LOGIN)
                && request.getParameter("password").equals(ADMIN_PASSWORD)) {
            request.getSession().setAttribute("username", user);

            List<Category> categories = new ArrayList<>();

            Category mobiles = new Category("Mobiles", "mobile.jpg", 1);
            Category laptops = new Category("Laptops", "laptop.jpg", 2);
            Category gps = new Category("GPS", "jps_nav.jpg", 3);
            Category fridges = new Category("Fridges", "fridge.jpg", 4);
            Category cars = new Category("Cars", "car.jpg", 5);
            Category camera = new Category("Camera", "camera.jpg", 6);

            categories.add(mobiles);
            categories.add(laptops);
            categories.add(gps);
            categories.add(fridges);
            categories.add(cars);
            categories.add(camera);

            request.setAttribute("categories", categories);

            return "home.jsp";
        } else {
            return "signing.jsp";
        }
    }
}

