package ru.graduation.votingSystem.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User extends AbstractBaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    @Email
    private String email;

    @Column(name = "password")
    @Size(min = 5, max = 64)
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public UserRoles getAdminRole() {
        if (roles.equals(UserRoles.ADMIN)) {
            return UserRoles.ADMIN;
        }
        return null;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", idLmVote=" + idLmVote +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                roles == user.roles;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name, email, roles);
    }
}
