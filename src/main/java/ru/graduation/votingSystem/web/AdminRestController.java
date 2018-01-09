package ru.graduation.votingSystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.graduation.votingSystem.model.User;
import ru.graduation.votingSystem.service.AdminService;
import ru.graduation.votingSystem.util.AuthorizedUser;

import java.util.List;

@RestController
@RequestMapping(AdminRestController.REST_URL)
public class AdminRestController {
    static final String REST_URL = "/rest/admin";

    @Autowired
    private AdminService adminService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers(){
        return adminService.getAllUsers(AuthorizedUser.getRole());
    }
}
