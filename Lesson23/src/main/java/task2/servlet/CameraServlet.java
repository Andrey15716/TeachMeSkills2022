package task2.servlet;

import task2.model.Camera;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/camera")
public class CameraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Camera> cameras = new ArrayList<>();
        Camera samsung = new Camera("Photo 1", "Лучший камера серии A", " ", 250);
        Camera iphone = new Camera("Photo 2", "В качестве новинки улучшенная камера", " ", 450);
        Camera xiaomi = new Camera("Photo 3", "Увеличенная емкость батареи", " ", 155);

        req.setAttribute("cameras", cameras);

        cameras.add(samsung);
        cameras.add(iphone);
        cameras.add(xiaomi);

        RequestDispatcher rd = req.getRequestDispatcher("camera.jsp");
        rd.forward(req, resp);
    }
}