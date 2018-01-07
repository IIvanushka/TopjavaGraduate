package ru.graduation.votingSystem.util;

import ru.graduation.votingSystem.model.AbstractBaseEntity;
import ru.graduation.votingSystem.model.UserRoles;

public class AuthorizedUser {
    private static int id = AbstractBaseEntity.START_SEQ;
    private static UserRoles role = UserRoles.ADMIN;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        AuthorizedUser.id = id;
    }

    public static void setRole(UserRoles role) {
        AuthorizedUser.role = role;
    }

    public static UserRoles getRole() {
        return role;
    }
}