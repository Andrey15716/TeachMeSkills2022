package servlet;

import model.Cart;
import model.Order;
import model.User;
import utils.OrderDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/order-now")
public class OrderNowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        User auth = (User) req.getSession().getAttribute("username");

        if (auth != null) {
            String productId = req.getParameter("id");
            int productQuantity = Integer.parseInt(req.getParameter("quantity"));
            if (productQuantity <= 0) {
                productQuantity = 1;
            }
            Order order = new Order();
            order.setId(Integer.parseInt(productId));
            order.setUId(auth.getId());
            order.setQuantity(productQuantity);
            order.setDate(formatter.format(date));

            OrderDAO orderDao = new OrderDAO();
            boolean result = orderDao.insertOrder(order);
            if (result) {
                List<Cart> cart_list = (List<Cart>) req.getSession().getAttribute("cart-list");
                if (cart_list != null) {
                    for (Cart c : cart_list) {
                        if (c.getId() == Integer.parseInt(productId)) {
                            cart_list.remove(c);
                            break;
                        }
                    }
                }
                resp.sendRedirect("orders.jsp");
            } else {
                System.out.println("order failed");
            }
        } else {
            resp.sendRedirect("signing.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
