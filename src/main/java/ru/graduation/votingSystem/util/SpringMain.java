package ru.graduation.votingSystem.util;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.graduation.votingSystem.model.User;
import ru.graduation.votingSystem.model.UserRoles;
import ru.graduation.votingSystem.service.UserService;

import java.util.Arrays;

public class SpringMain {

    private static UserService userService;



    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml")) {
            System.out.println("---------------------------------BEANS---------------------------------");
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("---------------------------------BEANS---------------------------------");

            userService = context.getBean(UserService.class);

            User user = new User();
            user.setName("Vasya");
            user.setEmail("@yandex.ru");
            user.setRole(UserRoles.ADMIN);
            userService.create(user);
            System.out.println(userService.get(AuthorizedUser.id()));
            user.setEmail("ya@yandex.ru");
            User user2 = new User();
            user2.setName("Vasya");
            user2.setEmail("ya@yandex.ru");
            user2.setRole(UserRoles.USER);
            userService.create(user2);
            userService.getAll().forEach(System.out::println);

        }
    }
}
