package ru.graduation.votingSystem.repository;

import org.springframework.stereotype.Repository;
import ru.graduation.votingSystem.model.Dish;
import ru.graduation.votingSystem.model.LunchMenu;
import ru.graduation.votingSystem.model.Restaurant;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class JpaAppRepo {

    @PersistenceContext
    private EntityManager em;

    public Restaurant saveRest(Restaurant restaurant) {
        if (restaurant.isNew()) {
            em.persist(restaurant);
            return restaurant;
        } else {
            return em.merge(restaurant);
        }
    }

    public Restaurant getRest(int id){
        return em.find(Restaurant.class, id);
    }

    public boolean deleteRest(int id){
        return em.createNamedQuery(Restaurant.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    public LunchMenu saveLM(LunchMenu lunchMenu) {
        if (lunchMenu.isNew()) {
            em.persist(lunchMenu);
            return lunchMenu;
        } else {
            return em.merge(lunchMenu);
        }
    }

    public LunchMenu getLM(int id){
        return em.find(LunchMenu.class, id);
    }

    public boolean deleteLM(int id){
        return em.createNamedQuery(LunchMenu.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    public Dish saveDish(Dish dish) {
        if (dish.isNew()) {
            em.persist(dish);
            return dish;
        } else {
            return em.merge(dish);
        }
    }

    public Dish getDish(int id){
        return em.find(Dish.class, id);
    }

    public boolean deleteDish(int id){
        return em.createNamedQuery(Dish.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }
}
