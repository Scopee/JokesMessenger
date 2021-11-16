package ru.pinguin.jokesmessenger.auth.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Stepan Khudyakov.
 */
@Configuration
@EnableJpaRepositories(basePackages = "ru.pinguin.jokesmessenger.auth.data")
@EntityScan(basePackages = "ru.pinguin.jokesmessenger.auth.data")
public class DatabaseConfig {}
