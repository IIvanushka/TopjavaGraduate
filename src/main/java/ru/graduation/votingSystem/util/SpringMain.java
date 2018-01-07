package ru.graduation.votingSystem.util;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.graduation.votingSystem.model.*;
import ru.graduation.votingSystem.repository.DishRepo;
import ru.graduation.votingSystem.repository.LunchMenuRepo;
import ru.graduation.votingSystem.repository.RestaurantRepo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SpringMain {

//    private static UserService userService;
//    private static VoteService voteService;
    private static RestaurantRepo restaurantRepo;
    private static LunchMenuRepo lunchMenuRepo;
    private static DishRepo dishRepo;


    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml")) {
            System.out.println("---------------------------------BEANS---------------------------------");
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("---------------------------------BEANS---------------------------------");

//            userService = context.getBean(UserService.class);
//            voteService = context.getBean(VoteService.class);
            restaurantRepo = context.getBean(RestaurantRepo.class);
            lunchMenuRepo = context.getBean(LunchMenuRepo.class);
            dishRepo = context.getBean(DishRepo.class);

            Restaurant restaurant = new Restaurant("Name", "Address");
//            restaurant.setId(AbstractBaseEntity.START_SEQ);
            restaurantRepo.save(restaurant);
            LunchMenu lunchMenu = new LunchMenu(restaurant.getId(), LocalDate.now());
            lunchMenuRepo.save(lunchMenu);
//            lunchMenu.setId(AbstractBaseEntity.START_SEQ + 1);
            Dish dish1 = new Dish(lunchMenu.getId(), "Kotletka", 1000.);
            Dish dish2 = new Dish(lunchMenu.getId(), "Pyureshka", 250.5);
//            dish1.setId(AbstractBaseEntity.START_SEQ + 2);
//            dish2.setId(AbstractBaseEntity.START_SEQ + 3);

            Set<Dish> dishSet = new HashSet<>();
            dishSet.add(dish1);
            dishSet.add(dish2);
            lunchMenu.setDishes(dishSet);

            Set<LunchMenu> lunchMenus = new HashSet<>();
            lunchMenus.add(lunchMenu);
            restaurant.setLunchMenu(lunchMenus);
//
//            voteService.vote(lunchMenu);
//            voteService.vote(lunchMenu);
//            voteService.vote(lunchMenu);
//            dishRepo.saveAll(dishSet);
//            lunchMenuRepo.saveAll(lunchMenus);
            restaurantRepo.save(restaurant);

            System.out.println(restaurant);


//            User user = new User();
//            user.setName("Vasya");
//            user.setEmail("@yandex.ru");
//            user.setRole(UserRoles.ADMIN);
//            userService.create(user);
//            System.out.println(userService.get(AuthorizedUser.id()));
//            user.setEmail("ya@yandex.ru");
//            User user2 = new User();
//            user2.setName("Vasya");
//            user2.setEmail("ya@yandex.ru");
//            user2.setRole(UserRoles.USER);
//            userService.create(user2);
//            userService.getAllUsers().forEach(System.out::println);

        }
    }
}
