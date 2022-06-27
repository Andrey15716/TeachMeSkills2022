<%@ page import="java.util.List" %>
<%@ page import="model.Cart" %>
<%@ page import="utils.ProductDAO" %>
<%@ page import="model.Order" %>
<%@ page import="utils.OrderDAO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User auth = (User) request.getSession().getAttribute("username");
    if (auth != null) {
        request.setAttribute("username", auth);
    }
    List<Cart> cart_list = (List<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProduct = null;
    if (cart_list != null) {
        ProductDAO pDao = new ProductDAO();
        cartProduct = pDao.getCartProduct(cart_list);
        int total = pDao.getTotalPrice(cart_list);
        request.setAttribute("total", total);
        request.setAttribute("cart_list", cart_list);
    }
%>
<html>
<head>
    <title>Cart Page</title>
    <link rel="stylesheet" type="text/css" href="resources/button_style.css">
    <%@include file="resources/head.jsp" %>
</head>
<body>
<%@include file="resources/navbar.jsp" %>
<div class="container my-3">
    <div class="d-flex py-3"><h3>Total Price: $ ${total} </h3>
        <a class="mx-3 btn btn-primary" href="cart-check-out">Check Out</a></div>
    <table class="table table-light">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
            <th scope="col">Price</th>
            <th scope="col">Buy now!</th>
            <th scope="col">Cancel</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (cartProduct != null) {
                for (Cart c : cartProduct) {%>
        <tr>
            <td><%=c.getName()%>
            </td>
            <td><%=c.getDescription()%>
            </td>
            <td><%=c.getPrice()%>
            </td>
            <td>
                <form action="order-now" method="post" class="form-inline">
                    <input type="hidden" name="id" value="<%= c.getId()%>" class="form-input">
                    <div class="form-group d-flex justify-content-between">
                        <a class="btn btn-sm btn-decrease" href="quantity-inc-dec?action=dec&id=<%=c.getId()%>">
                            <i class="fas fa-minus-square"></i></a>
                        <label>
                            <input type="text" name="quantity" class="form-control" value="<%=c.getQuantity()%>">
                        </label>
                        <a class="btn bnt-sm btn-increase" href="quantity-inc-dec?action=inc&id=<%=c.getId()%>">
                            <i class="fas fa-plus-square"></i></a>
                    </div>
                    <button type="submit" class="btn btn-primary btn-sm">Buy</button>
                </form>
            </td>
            <td><a href="remove-from-cart?id=<%=c.getId() %>" class="btn btn-sm btn-danger">Remove</a></td>
        </tr>
        <%
                }
            }%>
        </tbody>
    </table>
</div>
<c:if test="${empty cart_list}">
    <h3><p class="text-center">В корзине нет товаров</p></h3>
</c:if>
<%@include file="resources/footer.jsp" %>
</body>
</html>