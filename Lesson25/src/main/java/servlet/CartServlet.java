package servlet;

import model.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        List<Cart> cartList = new ArrayList<>();

        int id = Integer.parseInt(req.getParameter("id"));
        Cart cart = new Cart();
        cart.setQuantity(1);
        cart.setId(id);

        HttpSession session = req.getSession();
        List<Cart> cart_list = (List<Cart>) session.getAttribute("cart-list");

        if (cart_list == null) {
            cartList.add(cart);
            session.setAttribute("cart-list", cartList);
            printWriter.print("Product added");

        } else {
            cartList = cart_list;
            boolean exist = false;
            for (Cart c : cart_list) {
                if (c.getId() == id) {
                    exist = true;
                    printWriter.print("Product exist");
                }

            }
            if (!exist) {
                cartList.add(cart);

            }
        }

//        req.setAttribute("cart", session.getAttribute("cart"));
//        RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
//        rd.forward(req, resp);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String description = req.getParameter("description");
//        String imageName = req.getParameter("ImageName");
//        int price = Integer.parseInt(req.getParameter("price"));
//        int id = Integer.parseInt(req.getParameter("id"));
//        Product product = new Product(id, name, description, imageName, price);
//        Cart cart = new Cart(new ArrayList<>());
//        cart.addProduct(product);
//        HttpSession session = req.getSession();
//        session.setAttribute("cart", cart);
//    }
}