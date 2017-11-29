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

    @Column(name = "id_restaurant", nullable = false)
    private Integer idRestaurant;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "vote", nullable = false)
    private Integer vote;

//    @Enumerated(EnumType.STRING)
//    @CollectionTable(name = "dishes", joinColumns = @JoinColumn(name = "ID"))
//    @Column(name = "ID")
//    @ElementCollection(fetch = FetchType.LAZY)
    @OneToMany
    private Set<Dish> dishes;

    public LunchMenu() {
    }

    public void incVote(){
        vote++;
    }

    public Integer getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Integer idRestaurant) {
        this.idRestaurant = idRestaurant;
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
                "idRestaurant=" + idRestaurant +
                ", date=" + date +
//                ", dishes=" + dishes +
                '}';
    }
}
