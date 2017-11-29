package ru.graduation.votingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.graduation.votingSystem.model.User;
import ru.graduation.votingSystem.repository.JpaUserRepo;

import java.util.List;

@Service
public class UserService {

    private JpaUserRepo userRepo;

    @Autowired
    public UserService(JpaUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User create(User user){
        return userRepo.save(user);
    }

    public boolean delete(int id){
        return userRepo.delete(id);
    }

    public User get(int id){
        return userRepo.get(id);
    }

    public void update(User user){
        userRepo.save(user);
    }

    public List<User> getAll(){
        return userRepo.getAll();
    }
}
