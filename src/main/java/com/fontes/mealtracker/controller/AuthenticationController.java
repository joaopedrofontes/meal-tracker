package com.fontes.mealtracker.controller;


import com.fontes.mealtracker.dto.user.UserAuthRequestDTO;
import com.fontes.mealtracker.dto.user.UserRequestDTO;
import com.fontes.mealtracker.repository.postgres.UserRepository;
import com.fontes.mealtracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    private final UserRepository userRepository;

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationController(AuthenticationManager authenticationManager, UserRepository userRepository, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Void> login(@RequestBody @Valid UserAuthRequestDTO dto) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(dto.email(), dto.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Void> register(@RequestBody @Valid UserRequestDTO dto) {
        if(userRepository.findByEmail(dto.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.getPassword());

        dto.setPassword(encryptedPassword);

        userService.save(dto);

        return ResponseEntity.ok().build();
    }

}
