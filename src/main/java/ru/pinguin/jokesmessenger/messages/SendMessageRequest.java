package ru.pinguin.jokesmessenger.messages;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class SendMessageRequest {
    private UUID from;

    private UUID to;

    private String message;
}
