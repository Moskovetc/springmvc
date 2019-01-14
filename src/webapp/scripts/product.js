var productsList = [];
var wasClosed = false;

function appendProducts() {
    var headphone, smartphone;
    for (var i = 0; i < 30; i++) {
        smartphone = createProduct('SmartPhone', 'resources/imgs/smartphone.png', 'smart' + i);
        document.getElementById("smtphns").appendChild(smartphone);
        productsList.push(smartphone);
    }
    for (var i = 0; i < 25; i++) {
        headphone = createProduct('HeadPhone', 'resources/imgs/headphone.png', 'head' + i);
        document.getElementById("hdphns").appendChild(headphone);
        productsList.push(headphone);
    }
}

function sendPost() {
    var xhr = new XMLHttpRequest();
    var body = 'products=get';
    xhr.open('POST', 'index', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    console.log(body);
    xhr.send(body);
}

function createProduct(name, imgSrc, id) {
    product = document.createElement('div');
    product.classList = 'product-container-onclick';
    product.id = id;
    product.appendChild(createElementImage(imgSrc));
    product.appendChild(createElementName(name));
    product.appendChild(createElementRandomPrice(1500, 10000));
    product.appendChild(createElementBasketButton(product.id));
    product.appendChild(createElementCloseButton(product.id));
    product.onclick = function () {
        if (!wasClosed){
            toggleDescription(this);
        }
        wasClosed = false;
    };
    return product;
}
function toggleDescription(elem) {
    if (elem.style.width === '100%') {
        hideDescription(elem);
    } else {
        hideAllDescriptions();
        showDescription(elem.id);
    }
}
function createElementImage(imgSrc) {
    var productImage = document.createElement('div');
    var image = document.createElement('img');
    image.src = imgSrc;
    productImage.appendChild(image);
    productImage.classList = 'image';
    return productImage;
}

function createElementName(name) {
    var productName = document.createElement("div");
    var min = 300;
    var max = 900;
    var randomModelName = 'Sumsungio' + (Math.floor(Math.random() * (max - min)) + min);
    productName.appendChild(document.createTextNode(name + '    ' + randomModelName));
    productName.classList = 'product-name';
    return productName;
}

function createElementPrice(price) {
    var productPrice = document.createElement("div");
    productPrice.appendChild(document.createTextNode(price));
    productPrice.classList = 'price';
    return productPrice;
}
function createElementRandomPrice(min, max) {
    var productPrice = document.createElement("div");
    var randomPrice = Math.floor(Math.random() * (max - min)) + min;
    productPrice.appendChild(document.createTextNode(String(randomPrice) + ' руб.'));
    productPrice.classList = 'price';
    return productPrice;
}
function createElementBasketButton(id) {
    var basketButton = document.createElement('div');
    basketButton.classList = 'basket-button';
    basketButton.appendChild(document.createTextNode('В корзину!'));
    basketButton.onclick = function () {
        buy(id);
    };
    return basketButton;
}
function createElementCloseButton(id) {
    var closeButton = document.createElement('div');
    closeButton.classList = 'close-button';
    var x = document.createElement('span');
    var txt = document.createTextNode('×');
    x.appendChild(txt);
    x.classList = 'close';
    closeButton.appendChild(x);
    closeButton.onclick = function () {
        removeFromBasket(id);
        wasClosed = true;
    };
    return closeButton;
}
function showDescription(id) {
    var product = document.getElementById(id);
    product.style.flexDirection = 'row';
    product.style.width = '100%';
    product.style.borderStyle = 'solid';
    product.style.borderColor = 'black';
    product.getElementsByClassName('price')[0].style.display = 'flex';
    product.getElementsByClassName('basket-button')[0].style.display = 'flex';
    $("html,body").animate({
        scrollTop: $('#' + id).offset().top - $('#' + id).height()
    }, 100);
}
function hideDescription(elem) {
    elem.removeAttribute("style");
    elem.style.flexDirection = 'column';
    elem.style.width = '135px';
    elem.getElementsByClassName('price')[0].style.display = 'none';
    elem.getElementsByClassName('basket-button')[0].style.display = 'none';
    elem.getElementsByClassName('close-button')[0].style.display = 'none';
}
function hideAllDescriptions() {
    var categories = document.getElementsByClassName('category');
    var list;
    for (var i = 0; i < categories.length; i++) {
        list = categories[i].getElementsByClassName('product-container-onclick');
        for (var j = 0; j < list.length; j++) {
            hideDescription(list[j]);
        }
    }
}