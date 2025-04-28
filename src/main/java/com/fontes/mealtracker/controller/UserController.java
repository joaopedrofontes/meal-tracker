package com.fontes.mealtracker.controller;

import com.fontes.mealtracker.dto.user.UserMapper;
import com.fontes.mealtracker.dto.user.UserRequestDTO;
import com.fontes.mealtracker.dto.user.UserResponseDTO;
import com.fontes.mealtracker.model.User;
import com.fontes.mealtracker.service.MealService;
import com.fontes.mealtracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService, MealService mealService) {
        this.userService = userService;
    }

    //criar user sem verificação
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO dto) {
        UserResponseDTO response = userService.save(dto);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody @Valid UserRequestDTO dto) {
        var response = userService.register(dto);
        if(response.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(response.get());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable UUID id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/by-email")
    public ResponseEntity<UserResponseDTO> getUserByEmail(@RequestParam String email) {
        return userService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> deleteUser(@PathVariable UUID id) {
        return userService.deleteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
