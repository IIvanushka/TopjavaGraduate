package ru.graduation.votingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.graduation.votingSystem.model.User;
import ru.graduation.votingSystem.model.UserRoles;
import ru.graduation.votingSystem.repository.UserRepo;
import ru.graduation.votingSystem.util.AuthorizedUser;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepo userRepo;

    public User CreateUser(User user){
        if (AuthorizedUser.getRole() == UserRoles.ADMIN) {
            return userRepo.save(user);
        }
        return null;
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }
}
