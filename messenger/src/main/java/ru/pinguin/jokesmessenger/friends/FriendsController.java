package ru.pinguin.jokesmessenger.friends;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.pinguin.jokesmessenger.common.exceptions.NotFoundException;
import ru.pinguin.jokesmessenger.friends.dto.FriendItem;
import ru.pinguin.jokesmessenger.friends.dto.FriendRequestItem;
import ru.pinguin.jokesmessenger.friends.dto.FriendRequestStatus;
import ru.pinguin.jokesmessenger.security.UserPrincipal;

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
    public void createFriendRequest(UserPrincipal principal, UUID userTo) throws Exception {
        service.createFriendRequest(principal.getUserId(), userTo);
    }

    @Override
    public List<FriendItem> getFriends(UserPrincipal principal) throws NotFoundException {
        return service.getFriends(principal.getUserId());
    }

    @Override
    public List<FriendRequestItem> getFriendRequests(UserPrincipal principal) throws NotFoundException {
        return service.getFriendRequests(principal.getUserId());
    }

    @Override
    public void responseToRequest(UserPrincipal principal, UUID requestId, FriendRequestStatus status) {
        service.responseToRequest(requestId, status);
    }
}
