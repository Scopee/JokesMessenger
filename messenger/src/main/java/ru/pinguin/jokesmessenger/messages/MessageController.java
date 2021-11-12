package ru.pinguin.jokesmessenger.messages;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MessageController implements MessagesApi{
    private final MessagesService messagesService;

    @Override
    public List<GetMessageRequest> getMessages(UUID userId, Integer offset, Integer limit) {
        return messagesService.getMessages(userId, offset, limit);
    }

    @Override
    public void markAsRead(UUID messageId) {
        messagesService.markAsRead(messageId);
    }

    @Override
    public void sendMessage(SendMessageRequest message) {
        messagesService.sendMessage(message);
    }
}
