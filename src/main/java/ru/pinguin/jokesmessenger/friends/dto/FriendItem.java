package ru.pinguin.jokesmessenger.friends.dto;

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

    private UUID friendId;

    private String username;

}
