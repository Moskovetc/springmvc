package com.epam.springmvc.api;

import com.epam.springmvc.data.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long productId);

    List<Product> getProducts();

    List<Product> getProductsByModel(String name);

    Long createProduct(String categoryName, Product product);

    void updateProduct(Product product);

    void deleteProduct(Long productId);
}
