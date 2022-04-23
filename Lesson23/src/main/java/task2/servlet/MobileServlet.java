package task2.servlet;

import task2.model.Mobile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/mobiles")
public class MobileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Mobile> mobiles = new ArrayList<>();
        Mobile samsung = new Mobile("Samsung A51", "Лучший мобильный телефон серии A", "samsung.jpg", 250);
        Mobile iphone = new Mobile("Iphone X", "В качестве новинки улучшенная камера", "iphone.jpg", 450);
        Mobile xiaomi = new Mobile("Xiaomi Poco", "Увеличенная емкость батареи", "xiaomi.jpg", 155);

        req.setAttribute("mobiles", mobiles);

        mobiles.add(samsung);
        mobiles.add(iphone);
        mobiles.add(xiaomi);

        RequestDispatcher rd = req.getRequestDispatcher("mobiles.jsp");
        rd.forward(req, resp);
    }
}
