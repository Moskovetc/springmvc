package com.epam.springmvc.api.impl;

import com.epam.springmvc.api.ProductService;
import com.epam.springmvc.data.Product;
import com.epam.springmvc.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private DataRepository repository;

    @Override
    public Product getProductById(Long id) {
        return repository.getProductById(id);
    }

    @Override
    public List<Product> getProducts() {
        return repository.getProducts();
    }

    @Override
    public List<Product> getProductsByModel(String modelName) {
        return repository.getProductsByModel(modelName);
    }

    @Override
    public Long createProduct(String categoryName, Product product) {
        return repository.createProduct(categoryName, product);
    }

    @Override
    public void updateProduct(Product product) {
        repository.updateProduct(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        repository.deleteProduct(productId);
    }
}
