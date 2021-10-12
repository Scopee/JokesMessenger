package ru.pinguin.jokesmessenger.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class UserRequest {
    @Schema(description = "User nickname", example = "{\"nickname\": Ivan12}")
    private String nickname;
    @Schema(description = "User id", example = "{\"user id\": 0123456789}")
    private UUID uuid;
}
