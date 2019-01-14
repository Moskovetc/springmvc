function showProducts() {
  var content = document.getElementById('search-modal');
  clearNode(content, 'products-list-search');
  var categories = document.getElementsByClassName('category');
  var list;
  for (var i = 0; i < categories.length; i++){
    list = categories[i].getElementsByClassName('product-container-onclick');
    for (var j = 0; j < list.length; j++) {
      var clonedElem =list[j].cloneNode(true);
      if (clonedElem.style.width === '100%') {
        hideDescription(clonedElem);
      }
      content.getElementsByClassName('products-list-search')[0].appendChild(clonedElem);
    }
  }
}

function filterProducts() {
  var input = document.getElementById('myInput');
  var filter = input.value.toUpperCase();
  var productList = document.getElementById('search-modal').getElementsByClassName('products-list-search')[0];
  var elems = productList.getElementsByClassName('product-container-onclick');
  var name, txtValue;
  for (i = 0; i < elems.length; i++) {
    name = elems[i].getElementsByClassName('product-name')[0];
    txtValue = name.textContent;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      elems[i].style.display = 'flex';
      elems[i].style.height = '50%'
    } else {
      elems[i].style.display = 'none';
    }
  }
}

function clearNode(element, className) {
  var node = element.getElementsByClassName(className)[0];
  while (node.firstChild) {
    node.removeChild(node.firstChild);
  }
}
