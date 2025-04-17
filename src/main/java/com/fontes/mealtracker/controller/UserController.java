package com.fontes.mealtracker.controller;

import com.fontes.mealtracker.dto.user.UserMapper;
import com.fontes.mealtracker.dto.user.UserRequestDTO;
import com.fontes.mealtracker.dto.user.UserResponseDTO;
import com.fontes.mealtracker.model.User;
import com.fontes.mealtracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDTO createUser(@RequestBody @Valid UserRequestDTO dto) {
        User user = UserMapper.toEntity(dto);
        User saved = userService.save(user);

        return UserMapper.toUserResponseDTO(saved);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable UUID id) {
        return userService.findById(id)
                .map(UserMapper::toUserResponseDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteById(id);
    }
}
