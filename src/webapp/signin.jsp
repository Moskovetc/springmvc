<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Регистрация</title>
    <link href="signin.css" rel="stylesheet">
</head>

<body style>
    <div class="signup-content">
        <div class="signup-title-block">
            <h2 class="signup-title">Авторизация</h2>
            <hr class="signup-hr">
        </div>
        <div class="signup-container" action="signin" method="post">
            <form action="signin" method="post">
              <p><input class="placeholder" id="login" placeholder="Логин" type="login" name="login"></p>
              <p><input class="placeholder" id="pass" placeholder="Пароль"type="password" name="password"></p>
              <p><input type="submit" class="signup-button" value="Отправить"></p>
             </form>

            <div class="alert-info">

            </div>
            <div class="info">
                <p><a class="ex1" href="signup">Зарегистрироваться</a></p>
            </div>
        </div>
    </div>
    <script src="scripts/signup.js"></script>
</body>

</html>