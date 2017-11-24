package ru.graduation.votingSystem.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.graduation.votingSystem.repository.JpaUserRepo;

import java.util.Arrays;

public class SpringMain {

    private static JpaUserRepo userRepo;

    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml")) {
            System.out.println("---------------------------------BEANS---------------------------------");
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("---------------------------------BEANS---------------------------------");
            userRepo = context.getBean(JpaUserRepo.class);
            userRepo.test().forEach((a, b) -> System.out.println(a + " - " + b));
        }
    }
}
