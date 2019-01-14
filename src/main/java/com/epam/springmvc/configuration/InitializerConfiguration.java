package com.epam.springmvc.configuration;

import com.epam.springmvc.DataInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitializerConfiguration {

    @Bean(initMethod = "initProducts")
    public DataInitializer productInitializer() {
        return new DataInitializer();
    }
}
