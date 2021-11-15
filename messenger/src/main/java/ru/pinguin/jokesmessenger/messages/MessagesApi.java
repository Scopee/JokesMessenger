package ru.pinguin.jokesmessenger.messages;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.pinguin.jokesmessenger.security.UserPrincipal;

import java.util.List;
import java.util.UUID;

@RequestMapping(MessagesApi.MESSAGES_API)
@Tag(name = "Messages Api")
public interface MessagesApi {
    String MESSAGES_API = "api/v1/messages";

    @Operation(summary = "Get messages by destination user id")
    @GetMapping
    List<GetMessageRequest> getMessages(@AuthenticationPrincipal UserPrincipal principal, @RequestParam Integer offset, @RequestParam Integer limit);

    @Operation(summary = "Mark message as read")
    @PutMapping("/{messageId}")
    void markAsRead(@AuthenticationPrincipal UserPrincipal principal, @PathVariable UUID messageId);

    @Operation(summary = "Send message")
    @PostMapping
    void sendMessage(@AuthenticationPrincipal UserPrincipal principal, @RequestBody SendMessageRequest message);
}
