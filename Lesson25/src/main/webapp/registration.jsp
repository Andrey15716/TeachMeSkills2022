<%@ page import="model.User" %>
<%@ page import="model.Cart" %>
<%@ page import="java.util.List" %><%
    User auth = (User) request.getSession().getAttribute("username");
    if (auth != null) {
        response.sendRedirect("index.jsp");
    }
    List<Cart> cart_list = (List<Cart>) session.getAttribute("cart-list");
    if (cart_list != null) {
        request.setAttribute("cart_list", cart_list);
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login form</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/validation.js"></script>
</head>
<body>

<div class="container">
    <div class="col-md-8 offset-md-4">
        <h2>Registration form</h2>
        <form method="post" action="${pageContext.request.contextPath}/register" class="needs-validation" novalidate>

            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control w-25" id="name" placeholder="Enter username" name="name"
                       required>
                <div class="invalid-feedback">Username should be entered!</div>
            </div>


            <div class="form-group">
                <label for="surname">Surname:</label>
                <input type="text" class="form-control w-25" id="surname" placeholder="Enter surname" name="surname"
                       required>
                <div class="invalid-feedback">Username should be entered!</div>
            </div>

            <div class="form-group">
                <label for="password">Password:</label>
                <input type="text" class="form-control w-25" id="password" placeholder="*******"
                       name="password"
                       required>
                <div class="invalid-feedback">Password should be entered!</div>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control w-25" id="email" placeholder="Enter email" name="email">
            </div>

            <div class="form-group">
                <label for="dateborn">Date born:</label>
                <input type="date" class="form-control w-25" id="dateborn" placeholder="Enter your birth date"
                       name="dateborn"
                       required>
                <div class="invalid-feedback">Birth date should be entered!</div>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary">Registration</button>
            </div>
        </form>
    </div>
</div>
<script>
    // Disable form submissions if there are invalid fields
    (function () {
        'use strict';
        window.addEventListener('load', function () {
            // Get the forms we want to add validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>
<%@include file="resources/footer.jsp" %>
</body>
</html>