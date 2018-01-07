package ru.graduation.votingSystem.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User extends AbstractBaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    private UserRoles roles;

    @Column(name = "ID_LM_VOTE")
    private Integer idLmVote;

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

    public UserRoles getRoles() {
        return roles;
    }

    public void setRoles(UserRoles role) {
        this.roles = role;
    }

    public Integer getIdLmVote() {
        return idLmVote;
    }

    public void setIdLmVote(Integer idLmVote) {
        this.idLmVote = idLmVote;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", idLmVote=" + idLmVote +
                '}';
    }
}
