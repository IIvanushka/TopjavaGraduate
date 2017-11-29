package ru.graduation.votingSystem.repository;

import org.springframework.stereotype.Repository;
import ru.graduation.votingSystem.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class JpaUserRepo {

    @PersistenceContext
    private EntityManager em;


    public User save(User user) {
        if (user.isNew()) {
            em.persist(user);
            return user;
        } else {
            return em.merge(user);
        }
    }

    public User get(int id) {
        return em.find(User.class, id);
    }

    public boolean delete(int id){
        return em.createNamedQuery(User.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    public List<User> getAll() {
        return em.createNamedQuery(User.ALL_SORTED, User.class).getResultList();
    }
}
