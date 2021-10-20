package ru.pinguin.jokesmessenger.friends;

import org.springframework.web.bind.annotation.*;
import ru.pinguin.jokesmessenger.friends.dto.FriendItem;
import ru.pinguin.jokesmessenger.friends.dto.FriendRequestItem;
import ru.pinguin.jokesmessenger.friends.dto.FriendRequestStatus;

import java.util.List;
import java.util.UUID;

/**
 * @author Stepan Khudyakov.
 */
@RequestMapping(FriendsApi.FRIENDS_API)
public interface FriendsApi {
    String FRIENDS_API = "/api/v1/friends";

    @PostMapping("/create")
    void createFriendRequest(@RequestParam UUID userFrom, @RequestParam UUID userTo) throws Exception;

    @GetMapping("/friends")
    List<FriendItem> getFriends(@RequestParam UUID userId);

    @GetMapping("/requests")
    List<FriendRequestItem> getFriendRequests(@RequestParam UUID userId);

    @PutMapping("/response")
    void responseToRequest(@RequestParam UUID userFrom, @RequestParam UUID userTo, @RequestParam FriendRequestStatus status);

}
