<%@ page import="model.Cart" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Order" %>
<%@ page import="utils.OrderDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User auth = (User) request.getSession().getAttribute("username");
    List<Order> orders = null;
    if (auth != null) {
        request.setAttribute("username", auth);
        OrderDAO orderDao = new OrderDAO();
        orders = orderDao.userOrder(auth.getId());
    } else {
        response.sendRedirect("signing.jsp");
    }
    List<Cart> cart_list = (List<Cart>) session.getAttribute("cart-list");
    if (cart_list != null) {
        request.setAttribute("cart_list", cart_list);
    }

%>
<html>
<head>
    <title>Order page</title>
    <%@include file="resources/head.jsp" %>
</head>
<body>
<%@include file="resources/navbar.jsp" %>
<div class="container">
    <div class="card-header my-3">All Orders</div>
    <table class="table table-light">
        <thead>
        <tr>
            <th scope="col">Date</th>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
            <th scope="col">Quantity</th>
            <th scope="col">Price</th>
            <th scope="col">Cancel</th>
        </tr>
        </thead>
        <tbody>

        <%
            if (orders != null) {
                for (Order o : orders) {%>
        <tr>
            <td><%=o.getDate() %>
            </td>
            <td><%=o.getName() %>
            </td>
            <td><%=o.getDescription() %>
            </td>
            <td><%=o.getQuantity() %>
            </td>
            <td><%=o.getPrice() %>
            </td>
            <td><a class="btn btn-sm btn-danger" href="cancel-order?id=<%=o.getOrderId()%>">Cancel Order</a></td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
<%@include file="resources/footer.jsp" %>
</body>
</html>
