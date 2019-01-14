package com.epam.springmvc;

import com.epam.springmvc.api.ProductService;
import com.epam.springmvc.data.Product;
import com.epam.springmvc.util.Generator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductInitializer {

    @Autowired
    private ProductService productService;

    public void initProducts() {
        List<Product> products = new Generator().getProducts(2);
        productService.createProduct(products.get(0));
        productService.createProduct(products.get(1));
    }

}
