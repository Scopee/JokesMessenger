package ru.pinguin.jokesmessenger.messages;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class GetMessageRequest {
    private UUID id;

    private UUID from;

    private UUID to;

    private String message;

    private LocalDateTime sentDate;
}
