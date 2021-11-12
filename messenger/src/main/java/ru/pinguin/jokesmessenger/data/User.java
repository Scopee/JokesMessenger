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
@Table(name = "users")
public class User {

    @Id
    private UUID id;

    private String nickname;

    @Column(name = "last_online")
    private LocalDateTime lastOnline;

    @Column(name = "registration_date_time")
    private LocalDateTime registrationDateTime;

}
