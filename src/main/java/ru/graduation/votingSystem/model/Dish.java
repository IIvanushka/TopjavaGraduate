package ru.graduation.votingSystem.model;

import javax.persistence.*;

@Entity
@Table(name = "dishes")
public class Dish extends AbstractBaseEntity {

//    @ManyToOne(fetch = FetchType.EAGER)
    @CollectionTable(name = "LUNCH_MENU", joinColumns = @JoinColumn(name = "ID"))
    @Column(name = "id_lunchmenu")
    private Integer idLunchmenu;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    public Dish() {
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

    @Override
    public String toString() {
        return "Dish{" +
//                "lmId=" + lmId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
