package servlet;

import model.Cart;
import model.Order;
import model.User;
import utils.OrderDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/cart-check-out")
public class CheckOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        List<Cart> cart_list = (List<Cart>) req.getSession().getAttribute("cart-list");
        User auth = (User) req.getSession().getAttribute("username");

        if (cart_list != null && auth != null) {
            for (Cart c : cart_list) {
                Order order = new Order();
                order.setId(c.getId());
                order.setUId(auth.getId());
                order.setQuantity(c.getQuantity());
                order.setDate(simpleDateFormat.format(date));

                OrderDAO orderDAO = new OrderDAO();
                boolean result = orderDAO.insertOrder(order);
                if (!result) {
                    break;
                }
                cart_list.clear();
                resp.sendRedirect("orders.jsp");
            }
        } else {
            if (auth == null) {
                resp.sendRedirect("signing.jsp");
            }
            resp.sendRedirect("cart.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}