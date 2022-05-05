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
                <input type="password" class="form-control w-25" id="password" placeholder="Enter password"
                       name="password"
                       required>
                <div class="invalid-feedback">Password should be entered!</div>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control w-25" id="email" placeholder="Enter email" name="email">
            </div>

            <button type="submit" class="btn btn-primary">Registration</button>
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
</body>
</html>