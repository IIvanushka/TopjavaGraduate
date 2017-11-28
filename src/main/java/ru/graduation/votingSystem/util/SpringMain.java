package ru.graduation.votingSystem.util;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.graduation.votingSystem.model.Restaurant;
import ru.graduation.votingSystem.repository.JpaAppRepo;
import ru.graduation.votingSystem.repository.JpaUserRepo;

import java.util.Arrays;

public class SpringMain {

    private static JpaUserRepo userRepo;
    private static JpaAppRepo appRepo;

    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml")) {
            System.out.println("---------------------------------BEANS---------------------------------");
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("---------------------------------BEANS---------------------------------");
            userRepo = context.getBean(JpaUserRepo.class);
            userRepo.test().forEach((a, b) -> System.out.println(a + " - " + b));

            appRepo = context.getBean(JpaAppRepo.class);
            appRepo.addRest(new Restaurant("First", "Moskva"));
            System.out.println(appRepo.getRest());

        }
    }
}
