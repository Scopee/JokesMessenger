package ru.pinguin.jokesmessenger.friends;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pinguin.jokesmessenger.data.Friend;
import ru.pinguin.jokesmessenger.friends.dto.FriendItem;
import ru.pinguin.jokesmessenger.friends.dto.FriendRequestItem;
import ru.pinguin.jokesmessenger.friends.dto.FriendRequestStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Stepan Khudyakov.
 */
@Service
@RequiredArgsConstructor
public class FriendsService {

    private final FriendsRepository repository;

    public void createFriendRequest(UUID userFrom, UUID userTo) throws Exception {
        Optional<Friend> byIds = repository.findByIds(userFrom, userTo);
        if (byIds.isPresent()) {
            throw new Exception();
        }
        Friend f = new Friend();
        f.setId(UUID.randomUUID());
        f.setFrom(userFrom);
        f.setTo(userTo);
        f.setAccepted(false);
        f.setDateTime(LocalDateTime.now());
        repository.persist(f);
    }

    public List<FriendItem> getFriends(UUID userId) {
        return repository.getFriendList(userId);
    }

    public List<FriendRequestItem> getFriendRequests(UUID userId) {
        return repository.getRequests(userId);
    }

    public void responseToRequest(UUID userFrom, UUID userTo, FriendRequestStatus status) {
        repository.responseToRequest(userFrom, userTo, status.isAccepted());
    }

}
