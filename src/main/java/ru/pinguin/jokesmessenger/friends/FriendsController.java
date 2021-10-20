package ru.pinguin.jokesmessenger.friends;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.pinguin.jokesmessenger.exceptions.NotFoundException;
import ru.pinguin.jokesmessenger.friends.dto.FriendItem;
import ru.pinguin.jokesmessenger.friends.dto.FriendRequestItem;
import ru.pinguin.jokesmessenger.friends.dto.FriendRequestStatus;

import java.util.List;
import java.util.UUID;

/**
 * @author Stepan Khudyakov.
 */
@RestController
@RequiredArgsConstructor
public class FriendsController implements FriendsApi {

    private final FriendsService service;

    @Override
    public void createFriendRequest(UUID userFrom, UUID userTo) throws Exception {
        service.createFriendRequest(userFrom, userTo);
    }

    @Override
    public List<FriendItem> getFriends(UUID userId) throws NotFoundException {
        return service.getFriends(userId);
    }

    @Override
    public List<FriendRequestItem> getFriendRequests(UUID userId) throws NotFoundException {
        return service.getFriendRequests(userId);
    }

    @Override
    public void responseToRequest(UUID userFrom, UUID userTo, FriendRequestStatus status) {
        service.responseToRequest(userFrom, userTo, status);
    }
}
