package ru.graduation.votingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.graduation.votingSystem.model.LunchMenu;
import ru.graduation.votingSystem.model.User;
import ru.graduation.votingSystem.model.UserRoles;
import ru.graduation.votingSystem.repository.LunchMenuRepo;
import ru.graduation.votingSystem.repository.UserRepo;

import java.time.LocalDate;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private LunchMenuRepo lunchMenuRepo;

    public User createUser(User user, UserRoles role){
        if (role == UserRoles.ADMIN) {
            return userRepo.save(user);
        }
        return null;
    }

    public List<User> getAllUsers(UserRoles role) {
        if (role == UserRoles.ADMIN) {
            return userRepo.findAll();
        }
        return null;
    }

    public LunchMenu createLunchMenu (LunchMenu lunchMenu, UserRoles role) {
        if (role == UserRoles.ADMIN) {
            return lunchMenuRepo.save(lunchMenu);
        }
        return null;
    }

}
