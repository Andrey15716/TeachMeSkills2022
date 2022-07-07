<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <div class="container">
        <a class="navbar-brand" href="${contextPath}/eshop?command=start_page">Online Shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="container-buttons">
            <a href="${contextPath}/eshop?command=search">
                <i class="fa-solid fa-magnifying-glass fa-3x" style="color: black"></i>
            </a>
            <a href="${contextPath}/eshop?command=start_page">
                <i class="fa-solid fa-house fa-3x" style="color: black"></i>
            </a>
            <a href="${contextPath}/eshop?command=redirect-to-profile">
                <i class="fa-solid fa-user fa-3x" style="color: black"></i>
            </a>
            <a href="${contextPath}/eshop?command=redirect-to-shopping-cart">
                <i class="fa-solid fa-cart-shopping fa-3x" style="color: black"></i>
            </a>
        </div>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="${contextPath}/eshop?command=redirect-to-shopping-cart">Cart<span
                        class="badge badge-danger">${cart.size()}</span> </a></li>
                <li class="nav-item"><a class="nav-link" href="${contextPath}/eshop?command=redirect-to-profile">Orders</a></li>
                <li class="nav-item"><a class="nav-link" href="${contextPath}/eshop?command=search">Search</a></li>
            </ul>
        </div>
    </div>
</nav>
