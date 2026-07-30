package com.devtrack.controller;

import com.devtrack.entity.User;
import com.devtrack.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/bulk")
    public List<User> createUsers(@RequestBody List<User> users) {
        return userService.createUsers(users);
    }
}