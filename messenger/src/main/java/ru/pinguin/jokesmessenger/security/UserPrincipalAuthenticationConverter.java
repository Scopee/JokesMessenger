package ru.pinguin.jokesmessenger.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;

import java.util.Map;
import java.util.UUID;

/**
 * @author Stepan Khudyakov.
 */
@SuppressWarnings("deprecation")
public class UserPrincipalAuthenticationConverter extends DefaultUserAuthenticationConverter {

    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        UserPrincipal principal = new UserPrincipal((String) map.get("user_name"),
                                                    "",
                                                    (String) map.get("role"),
                                                    UUID.fromString((String) map.get("user_id")));
        return new UsernamePasswordAuthenticationToken(principal, "N/A", principal.getAuthorities());
    }
}
