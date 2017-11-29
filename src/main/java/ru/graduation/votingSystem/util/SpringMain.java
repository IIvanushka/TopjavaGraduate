package ru.graduation.votingSystem.util;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.graduation.votingSystem.model.Restaurant;
import ru.graduation.votingSystem.model.User;
import ru.graduation.votingSystem.model.UserRoles;
import ru.graduation.votingSystem.repository.JpaAppRepo;
import ru.graduation.votingSystem.repository.JpaUserRepo;
import ru.graduation.votingSystem.service.AppService;

import java.util.Arrays;

public class SpringMain {

    private static AppService appService;



    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml")) {
            System.out.println("---------------------------------BEANS---------------------------------");
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("---------------------------------BEANS---------------------------------");

            appService = context.getBean(AppService.class);

            User user = new User();
            user.setName("Vasya");
            user.setEmail("@yandex.ru");
            user.setRole(UserRoles.ADMIN);
            appService.create(user);
            System.out.println(appService.get(AuthorizedUser.id()));
            user.setEmail("ya@yandex.ru");
            appService.update(user);
            System.out.println(appService.get(AuthorizedUser.id()));
//            appRepo = context.getBean(JpaAppRepo.class);
//            appRepo.addRest(new Restaurant("Third", "Moskva"));
//            System.out.println(appRepo.getRest());

        }
    }
}
