package com.example.restservisewithspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.restservisewithspring.repository")
public class RestServiceWithSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestServiceWithSpringApplication.class, args);
    }

}
