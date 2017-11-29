package ru.graduation.votingSystem.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = LunchMenu.DELETE, query = "DELETE FROM LunchMenu lm WHERE lm.id=:id"),
        @NamedQuery(name = LunchMenu.ALL_SORTED, query = "SELECT lm FROM LunchMenu lm ORDER BY lm.date desc"),
})

@Entity
@Table(name = "lunch_menu")
public class LunchMenu extends AbstractBaseEntity {

    public static final String DELETE = "LunchMenu.delete";
    public static final String ALL_SORTED = "LunchMenu.getAllSorted";

    @Column(name = "id_rest", nullable = false)
    private Integer idRest;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "votes", nullable = false)
    private Integer vote;

    @OneToMany
    @JoinColumn(name = "ID_LUNCH_MENU", referencedColumnName = "ID")
    private Set<Dish> dishes;

    public LunchMenu() {
    }

    public LunchMenu(Integer idRest, LocalDate date) {
        this.idRest = idRest;
        this.date = date;
        this.vote = 0;
    }

    public void incVote() {
        vote++;
    }

    public Integer getIdRest() {
        return idRest;
    }

    public void setIdRest(Integer idRestaurant) {
        this.idRest = idRestaurant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "LunchMenu{" +
                "idRestaurant=" + idRest +
                ", date=" + date +
                ", vote=" + vote +
                ", dishes=" + dishes +
                '}';
    }
}
