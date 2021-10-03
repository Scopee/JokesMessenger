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
@Table(name = "friends")
public class Friend {

    @Id
    private UUID id;

    private UUID from;

    private UUID to;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "accepted")
    private boolean isAccepted;
}
