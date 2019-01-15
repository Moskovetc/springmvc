package com.epam.springmvc.configuration;

import com.epam.springmvc.repository.DataRepository;
import com.epam.springmvc.repository.impl.DataRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public DataRepository productRepository() {
        return new DataRepositoryImpl();
    }

}
