package ru.graduation.votingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.graduation.votingSystem.model.LunchMenu;
import ru.graduation.votingSystem.model.User;
import ru.graduation.votingSystem.repository.LunchMenuRepo;
import ru.graduation.votingSystem.repository.UserRepo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class VotingService {

    @Autowired
    private LunchMenuRepo lunchMenuRepo;

    @Autowired
    private UserRepo userRepo;

    public List<LunchMenu> getAllLunchMenus() {
        return lunchMenuRepo.findAll();
    }

    public List<LunchMenu> getLunchMenusOfTheDay(){
        return lunchMenuRepo.findAllByDate(LocalDate.now());
    }

    public boolean voteFor(LunchMenu lunchMenu, int userId) {
        Optional<User> optionalUser = userRepo.findById(userId);
        User user;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            return false;
        }

        if (user.getIdLmVote() != null && LocalTime.now().getHour() < 11) {
            vote(lunchMenu, user);
            return true;
        }

        if (user.getIdLmVote() == null) {
            vote(lunchMenu, user);
            return true;
        }
        return false;
    }

    private void vote(LunchMenu lunchMenu, User user) {
        if (user.getIdLmVote() != null) {
            LunchMenu lunchMenu1 = lunchMenuRepo.findById(user.getIdLmVote()).get();
            lunchMenu1.decVote();
            lunchMenuRepo.save(lunchMenu1);
        }
        user.setIdLmVote(lunchMenu.getId());
        lunchMenu.incVote();
        userRepo.save(user);
        lunchMenuRepo.save(lunchMenu);
    }

}
