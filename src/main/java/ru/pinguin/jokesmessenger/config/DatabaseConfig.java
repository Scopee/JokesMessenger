package ru.pinguin.jokesmessenger.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.support.DatabaseStartupValidator;

import javax.sql.DataSource;

/**
 * @author Stepan Khudyakov.
 */
@Configuration
@EntityScan(basePackages = "ru.pinguin")
public class DatabaseConfig {
    @Bean
    public DatabaseStartupValidator databaseStartupValidator(DataSource dataSource) {
        var dsv = new DatabaseStartupValidator();
        dsv.setDataSource(dataSource);
        return dsv;
    }
}
