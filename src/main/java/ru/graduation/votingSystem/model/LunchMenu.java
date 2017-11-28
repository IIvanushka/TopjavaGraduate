package ru.graduation.votingSystem.model;

import java.time.LocalDate;
import java.util.Set;

public class LunchMenu extends AbstractBaseEntity {

    private Integer idRestaurant;

    private LocalDate date;

    private Set<Dish> dishes;

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
                ", dishes=" + dishes +
                '}';
    }
}
