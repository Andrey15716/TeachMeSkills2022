<%@ page import="model.User" %>
<%@ page import="model.AccountData" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="home.jsp">Online Shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="home.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="cart.jsp">Cart <span
                        class="badge badge-danger">${cart_list.size()}</span> </a></li>
                <%
                    if (auth != null) {
                %>
                <li class="nav-item"><a class="nav-link" href="orders.jsp">Orders</a></li>
                <li class="nav-item"><a class="nav-link" href="signing.jsp">Login</a></li>
                <%
                } else {
                %>

                <li class="nav-item"><a class="nav-link" href="log-out">Logout</a></li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>