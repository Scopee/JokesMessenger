package ru.pinguin.jokesmessenger.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserRequest {
    @Schema(description = "User nickname", example = "Ivan12")
    private String nickname;
}
