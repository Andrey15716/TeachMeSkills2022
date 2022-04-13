package servletexample;

import utils.Calculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String sum = String.valueOf(Calculator.sum(2, 4));
        req.setAttribute("sum", sum);

        String multiply = String.valueOf(Calculator.multiply(2, 4));
        req.setAttribute("multiply", multiply);

        String divide = String.valueOf(Calculator.divide(4, 2));
        req.setAttribute("divide", divide);

        String subtraction = String.valueOf(Calculator.subtraction(3.3, 2));
        req.setAttribute("subtraction", subtraction);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}