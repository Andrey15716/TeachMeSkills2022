package servlet;

import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("login", login);

        System.out.println("Логин: " + login);
        System.out.println("Пароль: " + password);

        if (!user.getLogin().equals(login) || !user.getPassword().equals(password)) {
            resp.getWriter().write("Неверный пароль. Обратитесь к администратору");
        } else {
            resp.getWriter().write("Вы успешно авторизовались");
            printWriter.print("<a href='info'> info</a>");
        }

        printWriter.print("<br><a href='logout'>logout</a>");
        printWriter.close();
    }
}