package com.epam.springmvc.repository.impl;

import com.epam.springmvc.data.Product;
import com.epam.springmvc.repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductRepositoryImpl implements ProductRepository {

    private long sequence = 0;
    Map<Long, Product> register = new HashMap<>();

    protected final Long nextPrivateKey() {
        return ++sequence;
    }

    @Override
    public Product getProductById(Long productId) {
        return register.get(productId);
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(register.values());
    }

    @Override
    public List<Product> getProductsByModel(String modelName) {
        return register.values().stream()
                .filter(product -> product.getModel().equals(modelName))
                .collect(Collectors.toList());
    }

    @Override
    public Long createProduct(Product product) {
        Long id = nextPrivateKey();
        product.setId(id);
        register.put(id, product);
        return id;
    }

    @Override
    public void updateProduct(Product product) {
        if (null != product.getId()) {
            register.put(product.getId(), product);
        }
    }

    @Override
    public void deleteProduct(Long productId) {
        register.remove(productId);
    }
}
