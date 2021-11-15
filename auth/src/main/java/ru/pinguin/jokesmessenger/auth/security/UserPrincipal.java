package ru.pinguin.jokesmessenger.auth.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;
import ru.pinguin.jokesmessenger.auth.data.UserInfo;
import ru.pinguin.jokesmessenger.common.security.Role;

import java.util.Collections;
import java.util.UUID;

/**
 * @author Stepan Khudyakov.
 */
@Getter
@Setter
public class UserPrincipal extends User {

    private final Role role;

    private final UUID userId;

    public UserPrincipal(UserInfo info) {
        super(info.getNickname(), info.getPassword(), Collections.singletonList(info.getRole().getAuthority()));
        role = info.getRole();
        userId = info.getId();
    }
}
