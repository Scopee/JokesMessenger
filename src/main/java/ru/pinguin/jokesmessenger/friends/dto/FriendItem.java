package ru.pinguin.jokesmessenger.friends.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @author Stepan Khudyakov.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendItem {

    @Schema(description = "Id of friend")
    private UUID friendId;

    @Schema(description = "Friend's username")
    private String username;

}
