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

    @Schema(description = "Id of friend", example = "123e4567-e89b-42d3-a456-556642440000")
    private UUID friendId;

    @Schema(description = "Friend's username", example = "testuser")
    private String username;

}
