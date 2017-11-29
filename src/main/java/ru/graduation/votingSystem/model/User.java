package ru.graduation.votingSystem.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
//        @NamedQuery(name = User.BY_EMAIL, query = "SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.email=?1"),
        @NamedQuery(name = User.ALL_SORTED, query = "SELECT u FROM User u ORDER BY u.name, u.email"),
})

@Entity
@Table(name = "USERS")
public class User extends AbstractBaseEntity {

    public static final String DELETE = "User.delete";
//    public static final String BY_EMAIL = "User.getByEmail";
    public static final String ALL_SORTED = "User.getAllSorted";

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;


//    private UserRoles roles;

    @Column(name = "LAST_VOTE")
    private LocalDateTime lastVote;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public UserRoles getRoles() {
//        return roles;
//    }
//
//    public void setRoles(UserRoles role) {
//        this.roles = role;
//    }

    public LocalDateTime getLastVote() {
        return lastVote;
    }

    public void setLastVote(LocalDateTime lastVote) {
        this.lastVote = lastVote;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
//                ", role=" + roles +
                ", lastVote=" + lastVote +
                '}';
    }
}
