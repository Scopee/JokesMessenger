package ru.pinguin.jokesmessenger.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Stepan Khudyakov.
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "auth")
public class AuthProperties {

    private String tokenUrl;

    private String authServerUrl;

    private String client;

    private String secret;


}
