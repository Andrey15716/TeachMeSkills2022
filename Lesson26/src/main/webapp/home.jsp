<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Categories</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h2>Popular categories</h2>

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
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="${contextPath}/eshop?command=redirect-to-shopping-cart">Cart</a>
                </li>
                <li class="nav-item"><a class="nav-link"
                                        href="${contextPath}/eshop?command=redirect-to-profile">Profile</a></li>
                <li class="nav-item"><a class="nav-link" href="${contextPath}/eshop?command=search">Search</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <c:if test="${not empty categories}">
        <div class="row">
            <c:forEach items="${categories}" var="category">
                <div class="card w-25 m-1" type="category">
                    <div class="card-body">
                        <a href="${contextPath}/eshop?command=category-redirect&category_id=${category.getId()}">${category.getName()}</a>
                        <img class="card-img" style="width:150px;height:120px"
                             src="${contextPath}/images/${category.getImageName()}" alt="Card image">
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
</div>
</body>
</html>
