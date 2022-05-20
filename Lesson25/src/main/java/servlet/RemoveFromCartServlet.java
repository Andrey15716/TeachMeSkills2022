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

@WebServlet("/remove-from-cart")
public class RemoveFromCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");

        if (id != null) {
            List<Cart> cart_list = (List<Cart>) req.getSession().getAttribute("cart-list");
            if (cart_list != null) {
                for (Cart c : cart_list) {
                    if (c.getId() == Integer.parseInt(id)) {
                        cart_list.remove(c);
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
