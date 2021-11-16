package ru.pinguin.jokesmessenger.auth.data;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

/**
 * @author Stepan Khudyakov.
 */
@Repository
@RequiredArgsConstructor
public class UserInfoRepository {

    @PersistenceContext
    private final EntityManager em;

    @Transactional
    public void persist(UserInfo user) {
        em.persist(user);
    }

    public boolean existsByNickname(String username) {
        return (boolean) em.createNativeQuery("select exists(select 1 from {h-schema}users where nickname = :username)")
                           .setParameter("username", username)
                           .getSingleResult();
    }

    public Optional<UserInfo> findByUsername(String username) {
        return em.createQuery("select i from UserInfo i where i.nickname =: username", UserInfo.class)
                 .setParameter("username", username)
                 .getResultList()
                 .stream()
                 .findFirst();
    }

}
