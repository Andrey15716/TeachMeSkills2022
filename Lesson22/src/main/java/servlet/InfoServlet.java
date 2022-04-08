package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class InfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter printWriter = resp.getWriter()) {
            HttpSession httpSession = req.getSession(false);
            String login = (String) httpSession.getAttribute("login");
            String password = (String) httpSession.getAttribute("password");
            printWriter.print("Ваш логин -" + login + ", Пароль " + password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
