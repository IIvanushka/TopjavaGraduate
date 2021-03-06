package ru.graduation.votingSystem.model;

import javax.persistence.*;

@Entity
@Table(name = "dishes")
public class Dish extends AbstractBaseEntity {

    @Column(name = "ID_LUNCH_MENU")
    private Integer idLunchmenu;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    public Dish() {
    }

    public Dish(Integer idLunchmenu, String name, Double price) {
        this.idLunchmenu = idLunchmenu;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getIdLunchmenu() {
        return idLunchmenu;
    }

    public void setIdLunchmenu(Integer idLunchmenu) {
        this.idLunchmenu = idLunchmenu;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "idLunchmenu=" + idLunchmenu +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
