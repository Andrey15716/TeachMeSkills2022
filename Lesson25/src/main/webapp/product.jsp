<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resources/style.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"></a>
        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
            <li class="nav-item">
                <a class="nav-link" href="login" style="color: aliceblue">Главная</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="cabinet" style="color: aliceblue">Кабинет</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="basket" style="color: aliceblue">Корзина</a>
            </li>
        </ul>
    </div>
</nav>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container-fluid">
    <c:if test="${not empty productsById}">
    <div class=" row">
        <p align="left" style="font-size: 22px">Наши товары</p>
        <c:forEach items="${productsById}" var="productsById">
            <div class="card w-25 m-1" type="product">
                <div class="card-body">
                    <p>Наименование</p>
                    <a>${productsById.getName()}</a>
                    <p>Описание</p>
                    <a>${productsById.getDescription()}</a>
                    <p>Цена</p>
                    <a>${productsById.getPrice()}</a>
                    <img class="card-img" style="width:150px;height:120px"
                         src="${contextPath}/images/${productsById.getImageName()}" alt="Card image">
                </div>
            </div>
            <div class="block1">
                <form method="post" action="/cart.jsp">
                    <button type="submit" class="btn btn-primary" name="id"
                            value="${productsById.getId()}">Купить
                    </button>
                </form>
            </div>
        </c:forEach>
    </div>
</div>
</c:if>
</body>
</html>