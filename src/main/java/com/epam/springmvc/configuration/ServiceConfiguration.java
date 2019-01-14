package com.epam.springmvc.configuration;

import com.epam.springmvc.api.ProductService;
import com.epam.springmvc.api.impl.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public ProductService productService() {
        return new ProductServiceImpl();
    }

}
