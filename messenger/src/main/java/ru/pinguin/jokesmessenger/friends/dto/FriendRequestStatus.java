package ru.pinguin.jokesmessenger.friends.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Stepan Khudyakov.
 */
@Getter
@RequiredArgsConstructor
public enum FriendRequestStatus {
    ACCEPT(true), DENY(false);

    private final boolean isAccepted;
}
