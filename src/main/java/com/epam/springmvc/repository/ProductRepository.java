package com.epam.springmvc.repository;

import com.epam.springmvc.data.Product;

import java.util.List;

public interface ProductRepository {
    Product getProductById(Long productId);

    List<Product> getProducts();

    List<Product> getProductsByModel(String name);

    Long createProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Long productId);
}
