package ru.pinguin.jokesmessenger.auth.security;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

/**
 * @author Stepan Khudyakov.
 */
public class HmacSecretKey implements SecretKey {

    private final byte[] secret;

    public HmacSecretKey(String secret) {
        this.secret = secret.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public String getAlgorithm() {
        return "HS256";
    }

    @Override
    public String getFormat() {
        return null;
    }

    @Override
    public byte[] getEncoded() {
        return secret;
    }
}
