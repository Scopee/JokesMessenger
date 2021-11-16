package ru.pinguin.jokesmessenger.friends.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Stepan Khudyakov.
 */
@Data
public class FriendRequestItem extends FriendItem {

    public FriendRequestItem(UUID friendId, String username, UUID requestId, LocalDateTime requestTime) {
        super(friendId, username);
        this.requestId = requestId;
        this.requestTime = requestTime;
    }

    @Schema(description = "Id of request", example = "123e4567-e89b-42d3-a456-556642440000")
    private UUID requestId;

    @Schema(description = "Create date time of request")
    private LocalDateTime requestTime;

}
