package ru.graduation.votingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.graduation.votingSystem.model.LunchMenu;

@Repository
public interface LunchMenuRepo extends JpaRepository<LunchMenu, Integer> {
}
