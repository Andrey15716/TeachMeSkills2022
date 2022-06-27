package servlet;

import model.AccountData;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.lang.System.out;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.getServletContext().getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String password = req.getParameter("password");
        String dateBorn = req.getParameter("dateborn");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateBorn, formatter);
        User user = new User(name, surname, password);

        if (!AccountData.isExistUser(user)) {
            AccountData.addUserToList(user);
            req.setAttribute("username", user);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/registration_success.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            out.print("Registration failed");
            resp.sendRedirect("registration.jsp");
        }
    }
}