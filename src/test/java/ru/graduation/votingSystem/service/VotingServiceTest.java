package ru.graduation.votingSystem.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.graduation.votingSystem.model.LunchMenu;
import ru.graduation.votingSystem.model.User;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class VotingServiceTest extends AbstractServiceTest{

    @Autowired
    private VotingService votingService;

    @Test
    public void getAllLunchMenus() {
        List<LunchMenu> allLunchMenus = votingService.getAllLunchMenus();
        allLunchMenus.forEach(System.out::println);
    }

    @Test
    public void getLunchMenusOfTheDay() {
        List<LunchMenu> allLunchMenus = votingService.getLunchMenusOfTheDay();
        allLunchMenus.forEach(System.out::println);
    }

    @Test(expected = AssertionError.class)
    public void voteFor() {
        List<LunchMenu> lunchMenus = votingService.getLunchMenusOfTheDay();
        LunchMenu lunchMenu = lunchMenus.get(0);
        boolean vote = votingService.voteFor(lunchMenu, 100000);
        LunchMenu expected = votingService.getLunchMenusOfTheDay().stream()
                .filter(lm -> lm.getVote() > 0)
                .findAny().get();
        Assert.assertEquals(true, vote);
        Assert.assertEquals(expected.getVote(), lunchMenu.getVote());

    }
}