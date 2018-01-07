package ru.graduation.votingSystem.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ru.graduation.votingSystem.model.LunchMenu;
import ru.graduation.votingSystem.model.User;
import ru.graduation.votingSystem.model.UserRoles;

import java.time.LocalDate;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;


public class AdminServiceTest extends AbstractServiceTest {

    private static final Logger log = getLogger(AdminServiceTest.class);

    @Autowired
    private AdminService adminService;

    @Test
    public void createUser() {
        User actual = new User();
        actual.setName("Admin Vasya");
        actual.setRoles(UserRoles.ADMIN);
        actual.setEmail("ya@yandex.ru");
        actual.setPassword("password");
        User expected = adminService.createUser(actual, UserRoles.ADMIN);
        Assert.assertEquals(expected, actual);

        User user = new User();
        user.setName("User Vasya");
        user.setEmail("ya2@yandex.ru");
        user.setRoles(UserRoles.USER);
        user.setPassword("userpassword");
        User user2 = adminService.createUser(user, UserRoles.ADMIN);
        Assert.assertEquals(user2, user);
    }

    @Test
    public void getAllUsers() {
        List<User> users = adminService.getAllUsers(UserRoles.ADMIN);
        System.out.println("--------------------------------------------------------------");
        users.stream().forEach(user -> log.info(user.toString()));
        System.out.println("--------------------------------------------------------------");
        //TODO AssertImpl
    }

    @Test
    public void createLunchMenu() {
        LunchMenu actual = new LunchMenu(100002, LocalDate.now());
        LunchMenu expected = adminService.createLunchMenu(actual, UserRoles.ADMIN);
        Assert.assertEquals(expected, actual);
    }
}