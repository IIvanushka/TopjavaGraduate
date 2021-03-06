package ru.graduation.votingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.graduation.votingSystem.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
