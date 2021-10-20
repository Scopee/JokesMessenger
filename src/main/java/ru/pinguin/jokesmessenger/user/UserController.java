package ru.pinguin.jokesmessenger.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.pinguin.jokesmessenger.data.User;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @Override
    public User getUser(UUID id) throws Exception {
        return userService.getUser(id);
    }

    @Override
    public void updateUser(UUID id, UserRequest user) {
        userService.updateUser(id, user);
    }

    @Override
    public UserRequest createUser(UserRequest user) throws Exception {
        return userService.createUser(user);
    }

}
