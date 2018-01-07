package ru.graduation.votingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.graduation.votingSystem.model.Dish;

import java.util.List;

@Repository
public interface DishRepo extends JpaRepository<Dish, Integer> {

    @Query("SELECT d FROM Dish d")
    List<Dish> getAll();
}
