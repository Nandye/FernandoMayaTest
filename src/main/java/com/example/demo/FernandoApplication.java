package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@EnableConfigurationProperties
public class FernandoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FernandoApplication.class, args);
    }

}
