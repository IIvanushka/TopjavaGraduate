package ru.graduation.votingSystem.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "lunch_menu")
public class LunchMenu extends AbstractBaseEntity {

    @Column(name = "id_restaurant", nullable = false)
    private Integer idRestaurant;

    @Column(name = "date", nullable = false)
    private LocalDate date;

//    @CollectionTable(name = "dishes", joinColumns = @JoinColumn(name = "lm_id"))
//    @ElementCollection(fetch = FetchType.EAGER)
//    private Set<Dish> dishes;

    public LunchMenu() {
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

//    public Set<Dish> getDishes() {
//        return dishes;
//    }
//
//    public void setDishes(Set<Dish> dishes) {
//        this.dishes = dishes;
//    }

    @Override
    public String toString() {
        return "LunchMenu{" +
                "idRestaurant=" + idRestaurant +
                ", date=" + date +
//                ", dishes=" + dishes +
                '}';
    }
}
