package task2.servlet;

import task2.model.Cars;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cars")
public class CarsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Cars> cars = new ArrayList<>();
        Cars samsung = new Cars("BMW", "Лучший двигатель серии A", " ", 250);
        Cars iphone = new Cars("Jaguar", "В качестве новинки улучшенная коробка передач", " ", 450);
        Cars xiaomi = new Cars("Audi", "Увеличенная емкость батареи", " ", 155);

        req.setAttribute("cars", cars);

        cars.add(samsung);
        cars.add(iphone);
        cars.add(xiaomi);

        RequestDispatcher rd = req.getRequestDispatcher("cars.jsp");
        rd.forward(req, resp);
    }
}
