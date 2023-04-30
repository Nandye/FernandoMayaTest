package com.example.demo.infrastructure.db.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@Configuration
@ConfigurationProperties("spring.datasource")
@EntityScan(basePackages = "com.example.fernando.infrastructure.db.entity")
@EnableJpaRepositories(
        basePackages = "com.example.fernando.infrastructure.db.repository")
public class DbJpaConfig {

}
