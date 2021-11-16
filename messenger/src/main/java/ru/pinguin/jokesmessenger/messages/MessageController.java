package ru.pinguin.jokesmessenger.messages;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RestController;
import ru.pinguin.jokesmessenger.security.UserPrincipal;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MessageController implements MessagesApi{
    private final MessagesService messagesService;

    @Override
    public List<GetMessageRequest> getMessages(UserPrincipal principal, Integer offset, Integer limit) {
        return messagesService.getMessages(principal.getUserId(), offset, limit);
    }

    @Override
    public void markAsRead(UserPrincipal principal, UUID messageId) {
        messagesService.markAsRead(messageId);
    }

    @Override
    public void sendMessage(UserPrincipal principal, SendMessageRequest message) {
        messagesService.sendMessage(principal.getUserId(), message);
    }
}
