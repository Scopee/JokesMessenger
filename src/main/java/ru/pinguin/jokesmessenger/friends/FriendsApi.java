package ru.pinguin.jokesmessenger.friends;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.pinguin.jokesmessenger.exceptions.NotFoundException;
import ru.pinguin.jokesmessenger.friends.dto.FriendItem;
import ru.pinguin.jokesmessenger.friends.dto.FriendRequestItem;
import ru.pinguin.jokesmessenger.friends.dto.FriendRequestStatus;

import java.util.List;
import java.util.UUID;

/**
 * @author Stepan Khudyakov.
 */
@RequestMapping(FriendsApi.FRIENDS_API)
@Tag(name = "Friends Api")
public interface FriendsApi {
    String FRIENDS_API = "/api/v1/friends";

    @PostMapping("/create")
    @Operation(summary = "Create friend request")
    void createFriendRequest(@RequestParam @Schema(description = "Id of request sender user", example = "123e4567-e89b-42d3-a456-556642440000") UUID userFrom,
                             @RequestParam @Schema(description = "Id of request receiver user", example = "123e4567-e89b-42d3-a456-556642440000") UUID userTo) throws Exception;

    @GetMapping("/friends")
    @Operation(summary = "Get list of friends")
    List<FriendItem> getFriends(@RequestParam @Schema(description = "Id of user", example = "123e4567-e89b-42d3-a456-556642440000") UUID userId) throws NotFoundException;

    @GetMapping("/requests")
    @Operation(summary = "Get list of friend requests")
    List<FriendRequestItem> getFriendRequests(@RequestParam @Schema(description = "Id of user", example = "123e4567-e89b-42d3-a456-556642440000") UUID userId) throws NotFoundException;

    @PutMapping("/response")
    @Operation(summary = "Reply to friend request")
    void responseToRequest(@RequestParam @Schema(description = "Id of request", example = "123e4567-e89b-42d3-a456-556642440000") UUID requestId,
                           @RequestParam @Schema(description = "Response", example = "ACCEPT") FriendRequestStatus status);

}
