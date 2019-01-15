package com.epam.springmvc;

import com.epam.springmvc.api.ProductService;
import com.epam.springmvc.data.Shop;
import com.epam.springmvc.repository.DataRepository;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class DataInitializer {

    private static final Logger LOG = LoggerFactory.getLogger(DataInitializer.class);
    private static final String SHOP_CONFIGURATION_PATH = "src/main/resources/shop.json";

    @Autowired
    private ProductService productService;
    @Autowired
    private DataRepository dataRepository;

    public void initProducts() {
        Gson gson = new Gson();
        Shop shop = new Shop();
        try (Reader reader = new FileReader(SHOP_CONFIGURATION_PATH)) {
            shop = gson.fromJson(reader, Shop.class);
        } catch (IOException e) {
            LOG.error(String.format("Shop configuration file %s not found or busy for another service",
                    SHOP_CONFIGURATION_PATH));
        }
        dataRepository.setShop(shop);
    }

}
