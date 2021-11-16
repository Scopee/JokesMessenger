package ru.pinguin.jokesmessenger.auth.data;

import lombok.Getter;
import lombok.Setter;
import ru.pinguin.jokesmessenger.common.security.Role;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Stepan Khudyakov.
 */
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserInfo {

    @Id
    private UUID id;

    private String nickname;

    private String password;

    @Column(name = "last_online")
    private LocalDateTime lastOnline;

    @Column(name = "registration_date_time")
    private LocalDateTime registrationDateTime;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
}
