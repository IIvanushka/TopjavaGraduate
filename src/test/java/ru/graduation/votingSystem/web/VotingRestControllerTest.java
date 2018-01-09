package ru.graduation.votingSystem.web;

import org.junit.Test;
import ru.graduation.votingSystem.service.AbstractControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class VotingRestControllerTest extends AbstractControllerTest{

    private static final String REST_URL = VotingRestController.REST_URL + '/';

    @Test
    public void getLunchMenusOfTheDay() throws Exception {
        mockMvc.perform(get(REST_URL))
                .andExpect(status().isOk());
    }

    @Test
    public void voteFor() {
    }
}