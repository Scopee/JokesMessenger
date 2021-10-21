package ru.pinguin.jokesmessenger.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class UserResponse extends UserRequest {

    @Schema(description = "User id", example = "123e4567-e89b-42d3-a456-556642440000")
    private UUID uuid;
}
