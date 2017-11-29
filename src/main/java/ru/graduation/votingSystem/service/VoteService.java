package ru.graduation.votingSystem.service;

import org.springframework.stereotype.Service;
import ru.graduation.votingSystem.model.LunchMenu;
import ru.graduation.votingSystem.model.Restaurant;
import ru.graduation.votingSystem.repository.JpaAppRepo;

@Service
public class VoteService {

    private JpaAppRepo jpaAppRepo;

    public VoteService(JpaAppRepo jpaAppRepo) {
        this.jpaAppRepo = jpaAppRepo;
    }

    public boolean vote(LunchMenu lunchMenu){
        lunchMenu.incVote();
        return true;
//        return jpaAppRepo.saveLM(lunchMenu) != null;
    }

    public Restaurant getRest(int id){
        return jpaAppRepo.getRest(id);
    }

    public Restaurant saveRest(Restaurant restaurant){
        return null;
    }

}
