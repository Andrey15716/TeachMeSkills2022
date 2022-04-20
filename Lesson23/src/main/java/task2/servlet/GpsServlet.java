package task2.servlet;

import task2.model.Gps;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/gps")
public class GpsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Gps> gps = new ArrayList<>();
        Gps samsung = new Gps("Samsung", "Лучший навигатор серии A", " ", 250);
        Gps iphone = new Gps("Panasonic", "В качестве новинки улучшенная камера", " ", 450);
        Gps xiaomi = new Gps("Xiaomi", "Увеличенная емкость батареи", " ", 155);

        req.setAttribute("gps", gps);

        gps.add(samsung);
        gps.add(iphone);
        gps.add(xiaomi);

        RequestDispatcher rd = req.getRequestDispatcher("gps.jsp");
        rd.forward(req, resp);
    }
}
