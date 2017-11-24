package ru.graduation.votingSystem.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Map;

@Repository
public class JpaUserRepo {

    @PersistenceContext
    private EntityManager em;

    public Map<String, Object> test(){
//        em.setProperty("First", 100500);
        return em.getProperties();
    }
}
