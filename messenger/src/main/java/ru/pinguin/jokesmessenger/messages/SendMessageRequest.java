package ru.pinguin.jokesmessenger.messages;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class SendMessageRequest {

    @Schema(description = "Receiver user id", example = "123e4567-e89b-42d3-a456-556642440000")
    private UUID to;

    @Schema(description = "Message text", example = "Some text")
    private String message;
}
