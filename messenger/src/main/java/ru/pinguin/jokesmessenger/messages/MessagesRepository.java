package ru.pinguin.jokesmessenger.messages;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.pinguin.jokesmessenger.data.Message;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class MessagesRepository {

    @PersistenceContext
    private final EntityManager em;

    @Transactional
    public void persist(Message message) {
        em.persist(message);
    }

    public List<Message> getMessages(UUID id, int offset, int limit) {
        String q = """
                select m from Message m where m.from = :id or m.to = :id
                """;
        return em.createQuery(q, Message.class).setParameter("id", id).setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    @Transactional
    public void markAsRead(UUID id) {
        String q = """
                update Message m set m.isSeen=true where m.id=:id
                """;
        em.createQuery(q).setParameter("id", id).executeUpdate();
    }
}
