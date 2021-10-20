package ru.pinguin.jokesmessenger.messages;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(MessagesApi.MESSAGES_API)
public interface MessagesApi {
    String MESSAGES_API = "api/v1/messages";

    @Operation(summary = "Get messages by destination user id")
    @GetMapping
    List<GetMessageRequest> getMessages(@RequestParam UUID userId, @RequestParam Integer offset, @RequestParam Integer limit);

    @Operation(summary = "Mark message as read")
    @PutMapping("/{messageId}")
    void markAsRead(@PathVariable UUID messageId);

    @Operation(summary = "Send message")
    @PostMapping
    void sendMessage(@RequestBody SendMessageRequest message);
}
