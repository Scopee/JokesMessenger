package ru.pinguin.jokesmessenger.auth.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import ru.pinguin.jokesmessenger.auth.dto.RegisterUserRequest;
import ru.pinguin.jokesmessenger.auth.security.UserPrincipal;
import ru.pinguin.jokesmessenger.common.exceptions.UserAlreadyRegistered;
import ru.pinguin.jokesmessenger.common.security.Role;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Stepan Khudyakov.
 */
@Repository
@Primary
@RequiredArgsConstructor
public class UsersService implements UserDetailsService {

    private final UserInfoRepository repository;

    private final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return new UserPrincipal(user);
    }

    public void register(RegisterUserRequest request) throws UserAlreadyRegistered {
        if (repository.existsByNickname(request.getNickname()))
            throw new UserAlreadyRegistered();
        UserInfo info = new UserInfo();
        info.setId(UUID.randomUUID());
        info.setNickname(request.getNickname());
        info.setPassword(encoder.encode(request.getPassword()));
        info.setRegistrationDateTime(LocalDateTime.now());
        info.setLastOnline(LocalDateTime.now());
        info.setRole(Role.USER);
        repository.persist(info);
    }
}
