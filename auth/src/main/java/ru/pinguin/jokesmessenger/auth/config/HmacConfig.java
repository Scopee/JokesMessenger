package ru.pinguin.jokesmessenger.auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import ru.pinguin.jokesmessenger.auth.security.HmacSecretKey;

/**
 * @author Stepan Khudyakov.
 */
@Configuration
public class HmacConfig {
    private final String secret;

    public HmacConfig(@Value("${security.secret}") String secret) {this.secret = secret;}

    @Bean
    public JwtDecoder decoder(HmacSecretKey hmacSecretKey) {
        return NimbusJwtDecoder.withSecretKey(hmacSecretKey).build();
    }

    @Bean
    public MacSigner signer() {
        return new MacSigner(secret);
    }

    @Bean
    public HmacSecretKey secretKey() {
        return new HmacSecretKey(secret);
    }
}
