package ru.pinguin.jokesmessenger.messages;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class GetMessageRequest {
    @Schema(description = "Message id", example = "123e4567-e89b-42d3-a456-556642440000")
    private UUID id;

    @Schema(description = "Sender user id", example = "123e4567-e89b-42d3-a456-556642440000")
    private UUID from;

    @Schema(description = "Receiver user id", example = "123e4567-e89b-42d3-a456-556642440000")
    private UUID to;

    @Schema(description = "Message text", example = "Some text")
    private String message;

    @Schema(description = "Message sent date and time", example = "2015-11-21T12:48:00.973")
    private LocalDateTime sentDate;
}
