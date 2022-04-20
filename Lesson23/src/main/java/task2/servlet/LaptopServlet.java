package task2.servlet;

import task2.model.Laptops;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/laptops")
public class LaptopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Laptops> laptops = new ArrayList<>();
        Laptops samsung = new Laptops("Samsung", "Лучший ноутбук серии A", " ", 250);
        Laptops iphone = new Laptops("MacBook", "В качестве новинки улучшенная камера", " ", 450);
        Laptops xiaomi = new Laptops("Xiaomi", "Увеличенная емкость батареи", " ", 155);

        req.setAttribute("laptops", laptops);

        laptops.add(samsung);
        laptops.add(iphone);
        laptops.add(xiaomi);

        RequestDispatcher rd = req.getRequestDispatcher("laptops.jsp");
        rd.forward(req, resp);
    }
}
