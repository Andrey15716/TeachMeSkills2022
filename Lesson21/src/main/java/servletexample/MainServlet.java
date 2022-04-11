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
        String varTextA = String.valueOf(Calculator.sum(2, 4));
        req.setAttribute("textA", varTextA);

        String sum = "Сумма двух чисел";
        req.setAttribute("sum", sum);

        String varTextB = String.valueOf(Calculator.multiply(2, 4));
        req.setAttribute("textB", varTextB);

        String multiply = "Умножение двух чисел";
        req.setAttribute("multiply", multiply);

        String varTextC = String.valueOf(Calculator.divide(4, 2));
        req.setAttribute("textC", varTextC);

        String division = "Деление чисел";
        req.setAttribute("division", division);

        String varTextD = String.valueOf(Calculator.subtraction(3.3, 2));
        req.setAttribute("textD", varTextD);

        String substraction = "Вычитание чисел";
        req.setAttribute("substraction", substraction);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}