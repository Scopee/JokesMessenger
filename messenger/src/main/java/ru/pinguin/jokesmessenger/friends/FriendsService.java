package ru.pinguin.jokesmessenger.friends;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pinguin.jokesmessenger.data.Friend;
import ru.pinguin.jokesmessenger.common.exceptions.AlreadyExistsException;
import ru.pinguin.jokesmessenger.common.exceptions.NotFoundException;
import ru.pinguin.jokesmessenger.friends.dto.FriendItem;
import ru.pinguin.jokesmessenger.friends.dto.FriendRequestItem;
import ru.pinguin.jokesmessenger.friends.dto.FriendRequestStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author Stepan Khudyakov.
 */
@Service
@RequiredArgsConstructor
public class FriendsService {

    private final FriendsRepository repository;

    public void createFriendRequest(UUID userFrom, UUID userTo) throws Exception {
        if (repository.existsByIds(userFrom, userTo)) {
            throw new AlreadyExistsException("Friend request already exists");
        }
        Friend f = new Friend();
        f.setId(UUID.randomUUID());
        f.setFrom(userFrom);
        f.setTo(userTo);
        f.setAccepted(false);
        f.setDateTime(LocalDateTime.now());
        repository.persist(f);
    }

    public List<FriendItem> getFriends(UUID userId) throws NotFoundException {
        if(!repository.existsById(userId)) {
            throw new NotFoundException("User not found");
        }
        return repository.getFriendList(userId);
    }

    public List<FriendRequestItem> getFriendRequests(UUID userId) throws NotFoundException {
        if(!repository.existsById(userId)) {
            throw new NotFoundException("User not found");
        }
        return repository.getRequests(userId);
    }

    public void responseToRequest(UUID reqeustId, FriendRequestStatus status) {
        repository.responseToRequest(reqeustId, status.isAccepted());
    }

}
