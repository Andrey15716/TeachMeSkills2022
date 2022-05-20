package servlet;

import model.Cart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/quantity-inc-dec")
public class IncDecServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        int id = Integer.parseInt(req.getParameter("id"));
        List<Cart> cart_list = (List<Cart>) req.getSession().getAttribute("cart-list");
        RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");

        if (action != null && id >= 1) {
            if (action.equals("inc")) {
                for (Cart c : cart_list) {
                    if (c.getId() == id) {
                        int quantity = c.getQuantity();
                        quantity++;
                        c.setQuantity(quantity);
                        rd.forward(req, resp);
                    }
                }
            }
            if (action.equals("dec")) {
                for (Cart c : cart_list) {
                    if (c.getId() == id && c.getQuantity() > 1) {
                        int quantity = c.getQuantity();
                        quantity--;
                        c.setQuantity(quantity);
                        break;
                    }
                }
                rd.forward(req, resp);
            }
        } else {
            rd.forward(req, resp);
        }
    }
}