package ru.pinguin.jokesmessenger.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pinguin.jokesmessenger.data.User;
import ru.pinguin.jokesmessenger.common.exceptions.NotFoundException;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public Iterable<User> getUsers() {
        return repository.findAll();
    }

    public User getUser(UUID id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }

    public void updateUser(UUID id, final UserRequest userRequest) throws Exception {
        User user = getUser(id);
        user.setNickname(userRequest.getNickname());
        repository.save(user);
    }

    public UserResponse createUser(UserRequest userRequest) throws Exception {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setNickname(userRequest.getNickname());
        user.setRegistrationDateTime(LocalDateTime.now());
        user.setLastOnline(LocalDateTime.now());
        repository.save(user);
        UserResponse response = new UserResponse();
        response.setNickname(userRequest.getNickname());
        response.setUuid(user.getId());
        return response;
    }
}
