package ru.pinguin.jokesmessenger.auth.security;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;

import java.util.Collections;
import java.util.Map;

/**
 * @author Stepan Khudyakov.
 */
@SuppressWarnings("deprecation")
public class CustomAccessTokenConverter extends DefaultAccessTokenConverter {

    @Override
    public Map<String, ?> convertAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        OAuth2Request request = authentication.getOAuth2Request();
        DefaultOAuth2AccessToken dToken = (DefaultOAuth2AccessToken) token;
        dToken.setScope(Collections.singleton("data"));
        return super.convertAccessToken(token, authentication);
    }
}
