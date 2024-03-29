package ru.pinguin.jokesmessenger.friends;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.pinguin.jokesmessenger.data.Friend;
import ru.pinguin.jokesmessenger.friends.dto.FriendItem;
import ru.pinguin.jokesmessenger.friends.dto.FriendRequestItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

/**
 * @author Stepan Khudyakov.
 */
@Repository
@RequiredArgsConstructor
public class FriendsRepository {

    @PersistenceContext
    private final EntityManager em;

    @Transactional
    public void persist(Friend friend) {
        em.persist(friend);
    }

    public boolean existsById(UUID id) {
        String q = """
                select count(u) from User u where u.id=:id
                """;
        return em.createQuery(q, Long.class).setParameter("id", id).getSingleResult() >= 1;
    }

    public boolean existsByIds(UUID userFrom, UUID userTo) {
        String q = """
                   select count(f.id) from Friend f where (f.from =:userFrom and f.to =:userTo) or (f.to=:userFrom and f.from =:userTo)
                   """;
        return em.createQuery(q, Long.class)
                 .setParameter("userFrom", userFrom)
                 .setParameter("userTo", userTo)
                 .getSingleResult() > 0;
    }

    public List<FriendItem> getFriendList(UUID userId) {
        String q1 = """
                select new ru.pinguin.jokesmessenger.friends.dto.FriendItem(f.to, u.nickname) from Friend f
                left join User u on u.id = f.to
                where f.from = :userId
                and f.isAccepted = true
                 """;
        String q2 = """
                select new ru.pinguin.jokesmessenger.friends.dto.FriendItem(f.from, u.nickname) from Friend f
                left join User u on u.id = f.from
                where f.to = :userId
                and f.isAccepted = true
                 """;
        List<FriendItem> list = em.createQuery(q1, FriendItem.class).setParameter("userId", userId).getResultList();
        list.addAll(
                em.createQuery(q2, FriendItem.class).setParameter("userId", userId).getResultList());
        return list;
    }

    public List<FriendRequestItem> getRequests(UUID userTo) {
        String q = """
                select new ru.pinguin.jokesmessenger.friends.dto.FriendRequestItem(f.from, u.nickname, f.id, f.dateTime) from Friend f 
                left join User u on u.id = f.from
                where f.to = :userId
                and f.isAccepted = false 
                """;
        return em.createQuery(q, FriendRequestItem.class).setParameter("userId", userTo).getResultList();
    }

    @Transactional
    public void responseToRequest(UUID requestIq, boolean accepted) {
        String q = """
                   update Friend f set f.isAccepted = :accepted where f.id =:id
                   """;

        em.createQuery(q).setParameter("accepted", accepted).setParameter("id", requestIq).executeUpdate();
    }
}
