package com.epam.springmvc;

import com.epam.springmvc.api.impl.ProductServiceImpl;
import com.epam.springmvc.configuration.ApplicationConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringmvcApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringmvcApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		context.getBean(ProductServiceImpl.class).getProducts().stream().forEach(product -> System.out.println(product));
	}

}

