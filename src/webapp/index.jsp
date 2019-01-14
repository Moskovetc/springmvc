<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Магазин всякая всячина</title>
    <link href="style.css" rel="stylesheet">
</head>

<body style onload="setDiscount();">
    <div class="fixed-position">
        <div class="navigation-row-container">
            <div class="nav-left">
                <span class="username-block">
                    <%=(String)session.getAttribute("firstName")%>
                    <%=(String)session.getAttribute("lastName")%>
                </span>
                <div class="login-button-block">
                        <form action="signout" method="get">
                              <p id="logout"><input type="submit" class="login-button" value="Logout"></p>
                        </form>
                </div>
            </div>
            <div class="nav-right">
                <div class="search-bar-block" id="search-button" onclick="showModal('search-modal');showProducts();">
                    <div class="search-bar-button">
                        Search...
                    </div>
                </div>
                <div class="basket-block" onclick="showModal('basket-modal'); showDescriptionInBasket();">
                    <div id="basket-button">
                        0
                    </div>
                </div>
            </div>
        </div>
    </div>
    <cc:forEach items="${categories}" var="cat">
    <div class="category">
        <div class="category-title-block">
            <h2 class="category-title">${cat.name}</h2>
            <hr class="category-hr">
        </div>
        <div class="products-container">
            <cc:forEach items="${cat.products}" var="product" varStatus="status">
                <div class="product-container-onclick" id=${product.id}>
                    <div class="image">
                        <img src=${product.imgSrc}>
                    </div>
                    <div class="product-name">
                        ${product.brand} ${product.model}
                    </div>
                    <div class="price">${product.price} руб.</div>
                    <div class="basket-button">В корзину!</div>
                    <div class="close-button">
                        <span class="close">×</span>
                    </div>
                </div>
            </cc:forEach>
        </div>
    </div>
    </cc:forEach>
    <div id="basket-modal" class="modal">
        <div class="basket-content-container">
            <div class="modal-content">
                <span class="close">&times;</span>
                <h2 class="popup-title">Корзина</h2>
                <hr class="popup-hr">
                <div class="products-list-basket">

                </div>
                <div class="sum-container">
                    <div class="sum">
                        <div class="text-sum">
                            Сумма товаров
                        </div>
                        <div class="count-sum">
                            12312
                        </div>
                    </div>
                    <div class="skidka">
                        <div class="text-skidka">
                            Скидка
                        </div>
                        <div class="count-skidka">
                            10%
                        </div>
                        <div class="sum-skidka">
                            12312
                        </div>
                    </div>
                    <div class="final">
                        <div class="text-final">
                            Итого
                        </div>
                        <div class="count-final">
                            12312
                        </div>
                        <div class="submit-button" onclick="submitButton()">
                            Оформить
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="search-modal" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <h2 class="popup-title">Поиск</h2>
            <div id="search-placeholder">
                <input type=search id="myInput" placeholder="Введите текст для поиска" onkeyup="filterProducts()">
                <hr class="popup-hr">
            </div>
            <div class="products-list-search">

            </div>
        </div>
    </div>
    <footer>
        <div class="footer-container">
            <hr class="footer-hr">
            <span class="footer-text">Текстовая информация для футера</span>
            <span class="produced-by">Student production</span>
        </div>
    </footer>
    <script src="scripts/jquery-3.3.1.min.js"></script>
    <script src="scripts/product.js"></script>
    <script src="scripts/modalWindow.js"></script>
    <script src="scripts/basket.js"></script>
    <script src="scripts/search.js"></script>
    <script src="scripts/discount.js"></script>
    <script src="scripts/submit.js"></script>
    <script src="scripts/signup.js"></script>
    <script src="scripts/navbar.js"></script>
</body>

</html>