package ru.pinguin.jokesmessenger.messages;

import liquibase.pro.packaged.U;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pinguin.jokesmessenger.data.Message;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class MessagesService {
    private final MessagesRepository messagesRepository;
    private final Random random;

    public MessagesService(MessagesRepository messagesRepository,@Value("${jokes.threshold}") Integer threshold) {
        this.messagesRepository = messagesRepository;
        this.threshold = threshold;
        random = new Random();
    }

    private final Integer threshold;

    public List<GetMessageRequest> getMessages(UUID userId, int offset, int limit) {
        return messagesRepository.getMessages(userId, offset, limit).stream().map(this::convertToRequest).toList();
    }

    public void markAsRead(UUID messageId) {
        messagesRepository.markAsRead(messageId);
    }

    @Transactional
    public void sendMessage(UUID userId, SendMessageRequest message) {
        messagesRepository.persist(convertToMessage(userId, message));
        String text = message.getMessage();
        if (shouldDoJokes(text)){
            String joke = getJoke(text);
            if (joke != null){
                SendMessageRequest jokeMessage = new SendMessageRequest();
                jokeMessage.setTo(message.getTo());
                jokeMessage.setMessage(joke);
                messagesRepository.persist(convertToMessage(userId, jokeMessage));
            }
        }
    }

    private boolean shouldDoJokes(String message){
        if (message.split(" ").length > 3) {
            double value = this.random.nextDouble();
            return value * 100 > threshold;
        }
        return false;
    }

    private String getJoke(String message){
        for (String word: Arrays.stream(message.split(" ")).sorted(Comparator.comparingInt(String::length)).toList()){
            String joke = "";
            // elastic.getJokeOrNull(word);
            if (joke != null){
                return joke;
            }
        };
        return null;
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
