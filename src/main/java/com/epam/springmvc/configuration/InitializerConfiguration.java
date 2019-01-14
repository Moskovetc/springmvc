package com.epam.springmvc.configuration;

import com.epam.springmvc.ProductInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitializerConfiguration {

    @Bean(initMethod = "initProducts")
    public ProductInitializer productInitializer() {
        return new ProductInitializer();
    }
}
