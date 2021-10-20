package ru.pinguin.jokesmessenger.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Stepan Khudyakov.
 */
@Getter
@Setter
@Entity
@Table(name = "message")
public class Message {

    @Id
    private UUID id;

    @Column(name = "user_from")
    private UUID from;

    @Column(name = "user_to")
    private UUID to;

    private String message;

    @Column(name = "sent_date")
    private LocalDateTime sentDate;

    @Column(name = "is_seen")
    private boolean isSeen;

}
