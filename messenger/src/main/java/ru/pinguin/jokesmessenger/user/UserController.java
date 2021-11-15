package ru.pinguin.jokesmessenger.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RestController;
import ru.pinguin.jokesmessenger.data.User;
import ru.pinguin.jokesmessenger.security.UserPrincipal;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public Iterable<User> getUsers(UserPrincipal principal) {
        return userService.getUsers();
    }

    @Override
    public User getUser(UserPrincipal principal, UUID id) throws Exception {
        return userService.getUser(id);
    }

}
