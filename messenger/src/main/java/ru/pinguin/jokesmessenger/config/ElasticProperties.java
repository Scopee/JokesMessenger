package ru.pinguin.jokesmessenger.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "auth")
public class ElasticProperties {

    private String tokenUrl;

    private String username;

    private String passsword;

}
