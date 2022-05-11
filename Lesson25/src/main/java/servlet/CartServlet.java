package servlet;

import model.Cart;
import model.Product;
import model.User;
import utils.CRUDUtils;
import utils.CartDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("products", session.getAttribute("products"));
        RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Product, Integer> products = Cart.getProducts();
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String imageName = req.getParameter("ImageName");
        int price = Integer.parseInt(req.getParameter("price"));
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = new Product(id, name, description, imageName, price);

        Cart.addProduct(product);
        products.forEach((product1, integer) -> System.out.println(product1));
        HttpSession session = req.getSession();
        session.setAttribute("products", products);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("cart.jsp");
        requestDispatcher.forward(req, resp);
    }
}
