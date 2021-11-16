package ru.pinguin.jokesmessenger.auth.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.pinguin.jokesmessenger.auth.data.UsersService;
import ru.pinguin.jokesmessenger.auth.dto.RegisterUserRequest;
import ru.pinguin.jokesmessenger.common.exceptions.UserAlreadyRegistered;

/**
 * @author Stepan Khudyakov.
 */
@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi{

    private final UsersService service;

    @Override
    public void register(RegisterUserRequest request) throws UserAlreadyRegistered {
        service.register(request);
    }
}
