package ru.pinguin.jokesmessenger.friends.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Stepan Khudyakov.
 */
@Data
public class FriendRequestItem extends FriendItem {

    public FriendRequestItem(UUID friendId, String username, LocalDateTime requestTime) {
        super(friendId, username);
        this.requestTime = requestTime;
    }

    @Schema(description = "Create date time of request")
    private LocalDateTime requestTime;

}
