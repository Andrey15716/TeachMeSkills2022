package task2.servlet;

import task2.model.Fridges;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/fridges")
public class FridgesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Fridges> fridges = new ArrayList<>();
        Fridges samsung = new Fridges("Fridge 1", "Лучший холодильник серии A", " ", 250);
        Fridges iphone = new Fridges("Fridge 2", "В качестве новинки улучшенная морозильная камера", " ", 450);
        Fridges xiaomi = new Fridges("Fridge 3", "Увеличенная емкость батареи", " ", 155);

        req.setAttribute("fridges", fridges);

        fridges.add(samsung);
        fridges.add(iphone);
        fridges.add(xiaomi);

        RequestDispatcher rd = req.getRequestDispatcher("fridges.jsp");
        rd.forward(req, resp);
    }
}