package ru.graduation.votingSystem.model;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = Restaurant.DELETE, query = "DELETE FROM Restaurant r WHERE r.id=:id"),
        @NamedQuery(name = Restaurant.ALL_SORTED, query = "SELECT r FROM Restaurant r ORDER BY r.name"),
})

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractBaseEntity {

    public static final String DELETE = "Restaurant.delete";
    public static final String ALL_SORTED = "Restaurant.getAllSorted";

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany
    @JoinColumn(name = "ID_REST", referencedColumnName = "ID")
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

    public Set<LunchMenu> getLunchMenu() {
        return lunchMenu;
    }

    public void setLunchMenu(Set<LunchMenu> lunchMenu) {
        this.lunchMenu = lunchMenu;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", lunchMenu=" + lunchMenu +
                '}';
    }
}
