package com.fontes.mealtracker.controller;

import com.fontes.mealtracker.model.User;
import com.fontes.mealtracker.service.UserSerivce;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private final UserSerivce userSerivce;

    public UserController(UserSerivce userSerivce) {
        this.userSerivce = userSerivce;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userSerivce.save(user);
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable UUID id) {
        return userSerivce.findById(id).orElse(null);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userSerivce.deleteById(id);
    }
}
