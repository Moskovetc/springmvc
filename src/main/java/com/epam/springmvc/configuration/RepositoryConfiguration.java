package com.epam.springmvc.configuration;

import com.epam.springmvc.repository.ProductRepository;
import com.epam.springmvc.repository.impl.ProductRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepositoryImpl();
    }

}
