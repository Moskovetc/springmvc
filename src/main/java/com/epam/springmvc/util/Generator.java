package com.epam.springmvc.util;

import com.epam.springmvc.data.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Generator {
    private List<String> brands = Arrays.asList("LG", "SONY");
    private List<String> models = Arrays.asList("Galaxy", "Sonic");
    private List<String> imgs = Arrays.asList("resources/imgs/smartphone.png", "resources/imgs/headphone.png");

    public List<Product> getProducts(int quantity) {
        Random random = new Random();
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Product product = new Product();
            product.setBrand(brands.get(random.nextInt(brands.size())));
            product.setModel(String.format("%s %s", models.get(random.nextInt(models.size())),
                    random.nextInt(1000)));
            product.setPrice(random.nextInt(20000));
            product.setId((long) i);
            product.setImgSrc(imgs.get(random.nextInt(imgs.size())));
            products.add(product);
        }
        return products;
    }
}
