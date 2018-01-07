package ru.graduation.votingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.graduation.votingSystem.model.Restaurant;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {


}
