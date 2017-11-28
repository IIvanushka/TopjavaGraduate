package ru.graduation.votingSystem.repository;

import org.springframework.stereotype.Repository;
import ru.graduation.votingSystem.model.Restaurant;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class JpaAppRepo {

    @PersistenceContext
    private EntityManager em;

    public void addRest(Restaurant restaurant){
        em.persist(restaurant);
    }

    public Restaurant getRest(){
        return em.find(Restaurant.class, 100000);
    }
}
