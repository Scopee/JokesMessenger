package ru.pinguin.jokesmessenger.user;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pinguin.jokesmessenger.data.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
