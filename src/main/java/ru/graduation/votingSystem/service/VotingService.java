package ru.graduation.votingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.graduation.votingSystem.repository.LunchMenuRepo;

@Service
public class VotingService {

    @Autowired
    private LunchMenuRepo lunchMenuRepo;

}
