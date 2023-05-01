package com.example.demo.infrastructure.db.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Configuration
@ConfigurationProperties("spring.datasource")
@EntityScan(basePackages = "com.example.demo.infrastructure.db.entity")
@EnableJpaRepositories(
        basePackages = "com.example.demo.infrastructure.db.repository")
@RequestMapping("/fernando")
public class DbJpaConfig {

}
