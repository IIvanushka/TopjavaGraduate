package ru.graduation.votingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.graduation.votingSystem.model.LunchMenu;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LunchMenuRepo extends JpaRepository<LunchMenu, Integer> {
    List<LunchMenu> findAllByDate(LocalDate localDate);
}
