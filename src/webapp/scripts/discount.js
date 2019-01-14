var discount = randomDiscount();
function randomDiscount() {
    var min = 0;
    var max = 100;
    var discount = Math.floor(Math.random() * (max - min)) + min;
    return discount;
}

function setDiscount() {
    var count = document.getElementsByClassName('count-skidka')[0];
    count.removeChild(count.firstChild);
    count.appendChild(document.createTextNode(String(discount) + '%'));
}