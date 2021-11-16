package ru.pinguin.jokesmessenger.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "elastic")
public class ElasticProperties {

    private String url;

    private String username;

    private String password;

}
