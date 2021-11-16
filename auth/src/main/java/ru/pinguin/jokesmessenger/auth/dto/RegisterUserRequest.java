package ru.pinguin.jokesmessenger.auth.dto;

import lombok.Data;

/**
 * @author Stepan Khudyakov.
 */
@Data
public class RegisterUserRequest {

    private String nickname;

    private String password;

}
