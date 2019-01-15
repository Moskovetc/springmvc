package com.epam.springmvc.repository.impl;

import com.epam.springmvc.data.Category;
import com.epam.springmvc.data.Product;
import com.epam.springmvc.data.Shop;
import com.epam.springmvc.repository.DataRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataRepositoryImpl implements DataRepository {

    private long sequence = 0;
    private Shop shop = new Shop();

    private Long nextPrivateKey() {
        return ++sequence;
    }

    @Override
    public Shop getShop() {
        return shop;
    }

    @Override
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public List<Category> getCategories() {
        return shop.getCategories();
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return shop.getCategories().stream()
                .filter(category -> category.getName().equals(categoryName))
                .findFirst().orElse(null);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return shop.getCategories().stream().filter(category -> category.getId().equals(categoryId))
                .findFirst().orElse(null);
    }

    @Override
    public Product getProductById(Long productId) {
        return getProducts().stream()
                .filter(product -> product.getId().equals(productId)).findFirst().orElse(null);
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        shop.getCategories().forEach(category -> products.addAll(category.getProducts()));
        return products;
    }

    @Override
    public List<Product> getProductsByModel(String modelName) {
        return getProducts().stream()
                .filter(product -> product.getModel().equals(modelName)).collect(Collectors.toList());
    }

    @Override
    public Long createProduct(String categoryName, Product product) {
        Long id = nextPrivateKey();
        product.setId(id);
        if (null != getCategoryByName(categoryName)) {
            shop.getCategories().forEach(category -> {
                if (category.getName().equals(categoryName)) {
                    category.getProducts().add(product);
                }
            });
        }
        return id;
    }

    @Override
    public void updateProduct(Product product) {
        if (null != product.getId() && null != getProductById(product.getId())) {
            shop.getCategories().forEach(category -> {
                if (category.getProducts().contains(product)) {
                    int indexOfProduct = category.getProducts().indexOf(product);
                    category.getProducts().set(indexOfProduct, product);
                }
            });
        }
    }

    @Override
    public void deleteProduct(Long productId) {
        if (null != getProductById(productId)) {
            shop.getCategories().forEach(category -> {
                if (category.getProducts().contains(getProductById(productId))) {
                    category.getProducts().remove(getProductById(productId));
                }
            });
        }
    }
}
