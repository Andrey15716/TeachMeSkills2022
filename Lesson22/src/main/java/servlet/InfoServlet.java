package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.print("Приветствие!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/info.jsp");
        requestDispatcher.forward(req, resp);
    }
}