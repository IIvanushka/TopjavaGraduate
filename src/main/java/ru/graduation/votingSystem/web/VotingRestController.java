package ru.graduation.votingSystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.graduation.votingSystem.model.LunchMenu;
import ru.graduation.votingSystem.service.VotingService;
import ru.graduation.votingSystem.util.AuthorizedUser;

import java.util.List;

@RestController
@RequestMapping(VotingRestController.REST_URL)
public class VotingRestController {
    static final String REST_URL = "/rest";

    @Autowired
    private VotingService votingService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LunchMenu> getLunchMenusOfTheDay(){
        return votingService.getLunchMenusOfTheDay();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void voteFor(@RequestBody LunchMenu lunchMenu , @PathVariable("id") int id) {
        votingService.voteFor(lunchMenu, AuthorizedUser.getId());
    }
}
