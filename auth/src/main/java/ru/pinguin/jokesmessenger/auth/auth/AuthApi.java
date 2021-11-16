package ru.pinguin.jokesmessenger.auth.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pinguin.jokesmessenger.auth.dto.RegisterUserRequest;
import ru.pinguin.jokesmessenger.common.exceptions.UserAlreadyRegistered;

/**
 * @author Stepan Khudyakov.
 */
@RequestMapping(AuthApi.AUTH_API)
public interface AuthApi {

    String AUTH_API = "/api/v1/auth";

    @PostMapping("/register")
    void register(@RequestBody RegisterUserRequest request) throws UserAlreadyRegistered, UserAlreadyRegistered;
}
