package ru.pinguin.jokesmessenger.messages;

import liquibase.pro.packaged.U;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pinguin.jokesmessenger.data.Message;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessagesService {
    private final MessagesRepository messagesRepository;

    public List<GetMessageRequest> getMessages(UUID userId, int offset, int limit) {
        return messagesRepository.getMessages(userId, offset, limit).stream().map(this::convertToRequest).toList();
    }

    public void markAsRead(UUID messageId) {
        messagesRepository.markAsRead(messageId);
    }

    public void sendMessage(UUID userId, SendMessageRequest message) {
        messagesRepository.persist(convertToMessage(userId, message));
    }

    private GetMessageRequest convertToRequest(Message message) {
        GetMessageRequest messageRequest = new GetMessageRequest();
        messageRequest.setId(message.getId());
        messageRequest.setTo(message.getTo());
        messageRequest.setFrom(message.getFrom());
        messageRequest.setMessage(message.getMessage());
        messageRequest.setSentDate(message.getSentDate());
        return messageRequest;
    }

    private Message convertToMessage(UUID userId, SendMessageRequest messageRequest) {
        Message message = new Message();
        message.setId(UUID.randomUUID());
        message.setFrom(userId);
        message.setTo(messageRequest.getTo());
        message.setMessage(messageRequest.getMessage());
        message.setSentDate(LocalDateTime.now());
        message.setSeen(false);
        return message;
    }
}
