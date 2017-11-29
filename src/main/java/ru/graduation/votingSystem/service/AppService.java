package ru.graduation.votingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.graduation.votingSystem.model.User;
import ru.graduation.votingSystem.repository.JpaUserRepo;

import java.util.List;

@Service
public class AppService {

    private JpaUserRepo userRepo;

    @Autowired
    public AppService(JpaUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User create(User user){

        return userRepo.save(user);
    }

    public void delete(int id){

    }

    public User get(int id){
        return userRepo.get(id);
    }

    public void update(User user){
        userRepo.save(user);
    }

    List<User> getAll(){
        return null;
    }
}
