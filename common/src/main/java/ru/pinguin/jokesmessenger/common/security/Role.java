package ru.pinguin.jokesmessenger.common.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * @author Stepan Khudyakov.
 */
public enum Role {
    USER, ADMIN;

    public GrantedAuthority getAuthority() {
        return new SimpleGrantedAuthority(this.name());
    }
}
