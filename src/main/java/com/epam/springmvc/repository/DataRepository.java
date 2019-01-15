package com.epam.springmvc.repository;

import com.epam.springmvc.data.Category;
import com.epam.springmvc.data.Product;
import com.epam.springmvc.data.Shop;

import java.util.List;

public interface DataRepository {
    Shop getShop();

    void setShop(Shop shop);

    List<Category> getCategories();

    Category getCategoryByName(String categoryName);

    Category getCategoryById(Long categoryId);

    Product getProductById(Long productId);

    List<Product> getProducts();

    List<Product> getProductsByModel(String name);

    Long createProduct(String categoryName, Product product);

    void updateProduct(Product product);

    void deleteProduct(Long productId);
}
