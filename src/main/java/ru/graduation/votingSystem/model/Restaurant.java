package ru.graduation.votingSystem.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractBaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "address")
    private String address;

//    @CollectionTable(name = "lunch_menu", joinColumns = @JoinColumn(name = "id_restaurant"))
//    @Column(name = "lunchMenu")
//    @ElementCollection(fetch = FetchType.LAZY)
    @OneToMany
    private Set<LunchMenu> lunchMenu;

    public Restaurant() {
    }

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public Set<LunchMenu> getLunchMenu() {
//        return lunchMenu;
//    }
//
//    public void setLunchMenu(Set<LunchMenu> lunchMenu) {
//        this.lunchMenu = lunchMenu;
//    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
