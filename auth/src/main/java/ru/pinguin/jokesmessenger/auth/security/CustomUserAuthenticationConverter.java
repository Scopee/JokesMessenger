package ru.pinguin.jokesmessenger.auth.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;

import java.util.Map;

/**
 * @author Stepan Khudyakov.
 */
@SuppressWarnings("deprecation")
public class CustomUserAuthenticationConverter extends DefaultUserAuthenticationConverter {
    @Override
    public Map<String, ?> convertUserAuthentication(Authentication authentication) {
        Map<String, Object> map = (Map<String, Object>) super.convertUserAuthentication(authentication);
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        map.put("role", principal.getRole());
        map.put("user_id", principal.getUserId());
        return map;
    }
}
