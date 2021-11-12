package ru.pinguin.jokesmessenger.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;
import ru.pinguin.jokesmessenger.common.security.Role;

import java.util.Collections;

/**
 * @author Stepan Khudyakov.
 */
@Getter
@Setter
public class UserPrincipal extends User {

    private final String nickname;

    private final Role role;

    public UserPrincipal(String username, String password, String role) {
        super(username, password, Collections.singletonList(Role.valueOf(role).getAuthority()));
        this.nickname = username;
        this.role = Role.valueOf(role);
    }
}
