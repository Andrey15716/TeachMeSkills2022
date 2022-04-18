<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My personal card</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="#">
    </a>
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="#" style="color: aliceblue">Отзывы</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#" style="color: aliceblue">Мой профиль</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#" style="color: aliceblue">Оставить заявку</a>
        </li>
    </ul>
</nav>

<div class="container-fluid">
    <h2 align="center" style="color:#b80b0b">My personal card</h2>
    <div class="card offset-md-5" style="width:253px">
        <img class="card-img-top" src="${pageContext.request.contextPath}/images/avatar.png" alt="Card image"
             style="width:250px;height:250px">
        <div class="card-body">
            <h1 class="card-title">Andrei Antonenka</h1>
            <p class="card-text">I have degree in electronics, and I am trying to get education in java programming</p>
            <a href="#" class="btn btn-primary stretched-link">click to see full profile</a>
        </div>
    </div>
</div>

<div class="container mt-3">
    <h2>Отзывы о нашей компании</h2>
    <p>Оставьте свой отзыв и получите бонус!</p><br>
    <div class="media border p-3">

        <img src="${pageContext.request.contextPath}/images/avatar2.png" alt="John Doe" class="mr-3 mt-3 rounded-circle"
             style="width:60px;">
        <div class="media-body">
            <h4>John Doe <small><i>Posted on February 19, 2016</i></small></h4>
            <p>Спасибо за Ваши услуги. Очень грамотный специалист!</p>
            <p>Выполняет быстро и качественно</p>
            <div class="media p-3">
                <img src="${pageContext.request.contextPath}/images/avatar3.png" alt="Jane Doe"
                     class="mr-3 mt-3 rounded-circle" style="width:45px;">
                <div class="media-body">
                    <h4>Andrei Antonenka <small><i>Posted on February 20 2016</i></small></h4>
                    <p>Благодарю за честный отзыв, Всегда рад помочь!</p>
                </div>
            </div>
        </div>
    </div>
</div>

<footer class="bg-dark text-center text-white">
    <div class="container p-4 pb-0">
        <section class="">
            <form action="">
                <div class="row d-flex justify-content-center">
                    <div class="col-auto">
                        <p class="pt-2">
                            <strong>Sign up for our newsletter</strong>
                        </p>
                    </div>

                    <div class="col-md-5 col-12">
                        <div class="form-outline form-white mb-4">
                            <input type="email" id="form5Example29" class="form-control"/>
                            <label class="form-label" for="form5Example29">Email address</label>
                        </div>
                    </div>
                    <div class="col-auto">
                        <button type="submit" class="btn btn-outline-light mb-4">
                            Subscribe
                        </button>
                    </div>
                </div>
            </form>
        </section>
    </div>

    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
        © 2022 Copyright:
        <a class="text-white">All Rights Reserved</a>
    </div>
</footer>

</body>
</html>
