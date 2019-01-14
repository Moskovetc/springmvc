<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Регистрация</title>
    <link href="signup.css" rel="stylesheet">
</head>

<body style>
    <div class="signup-content">
        <div class="signup-title-block">
            <h2 class="signup-title">Регистрация</h2>
            <hr class="signup-hr">
        </div>
        <div class="signup-container">
                    <form action="signup" method="post">
                      <input type=search class="placeholder" id="name" placeholder="Имя" onkeyup="tape('name')">
                                  <input type=search class="placeholder" id="lastname" placeholder="Фамилия" onkeyup="tape('lastname')">
                                  <input type=search class="placeholder" id="login" placeholder="Логин" onkeyup="tape('login')">
                                  <input type=search class="placeholder" id="pass" placeholder="Пароль" onkeyup="tape('pass')">
                                  <input type=search class="placeholder" id="retrypass" placeholder="Повторите пароль" onkeyup="tape('retrypass')">
                                  <div class="signup-button" onclick="validation(true);">
                                                  <div class="highlight">
                                                      Зарегистрироваться
                                                  </div>
                                              </div>
                     </form>
            <div class="alert-info">

            </div>

            <div class="info">
                <p><a class="ex1" href="signin">Авторизация</a></p>
            </div>
        </div>
    </div>
    <script src="scripts/signup.js"></script>
</body>

</html>