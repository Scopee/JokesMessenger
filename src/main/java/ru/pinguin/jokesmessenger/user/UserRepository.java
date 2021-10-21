package ru.pinguin.jokesmessenger.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.pinguin.jokesmessenger.data.User;

import java.util.UUID;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, UUID> {
}
