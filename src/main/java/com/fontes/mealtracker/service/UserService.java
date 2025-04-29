package com.fontes.mealtracker.service;


import com.fontes.mealtracker.dto.user.UserMapper;
import com.fontes.mealtracker.dto.user.UserRequestDTO;
import com.fontes.mealtracker.dto.user.UserResponseDTO;
import com.fontes.mealtracker.dto.user.UserPatchRequestDTO;
import com.fontes.mealtracker.model.User;
import com.fontes.mealtracker.repository.postgres.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    //salvar sem verificação
    public UserResponseDTO save(UserRequestDTO dto) {
        User user = UserMapper.toEntity(dto);
        User saved = userRepository.save(user);
        return UserMapper.toUserResponseDTO(saved);
    }

    public Optional<UserResponseDTO> register(UserRequestDTO dto) {
        if(userRepository.findByEmail(dto.getEmail()).isPresent()) {
            return Optional.empty();
        }

        String encryptedPassword = passwordEncoder.encode(dto.getPassword());

        dto.setPassword(encryptedPassword);

        User user = UserMapper.toEntity(dto);
        User saved = userRepository.save(user);

        return Optional.of(UserMapper.toUserResponseDTO(saved));
    }

    public Optional<UserResponseDTO> findById(UUID id) {
        return userRepository.findById(id)
                .map(UserMapper::toUserResponseDTO);
    }

    public Optional<UserResponseDTO> findByEmail(String email) {
            return userRepository.findByEmail(email)
                    .map(UserMapper::toUserResponseDTO);
    }

    public Optional<UserResponseDTO> update(UUID id, UserRequestDTO dto) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setEmail(dto.getEmail());
                    user.setName(dto.getName());
                    user.setPassword(passwordEncoder.encode(dto.getPassword()));
                    user.setRole(dto.getRole());
                    User updatedUser = userRepository.save(user);
                    return UserMapper.toUserResponseDTO(updatedUser);
                });
    }

    public Optional<UserResponseDTO> patch(UUID id, UserPatchRequestDTO dto) {
        return userRepository.findById(id)
                .map(user -> {
                    if (dto.email() != null) {
                        user.setEmail(dto.email());
                    }
                    if (dto.name() != null) {
                        user.setName(dto.name());
                    }
                    if (dto.password() != null) {
                        user.setPassword(passwordEncoder.encode(dto.password()));
                    }
                    if (dto.role() != null) {
                        user.setRole(dto.role());
                    }
                    User updated = userRepository.save(user);
                    return UserMapper.toUserResponseDTO(updated);
                });
    }

    public Optional<UserResponseDTO> deleteById(UUID id) {
        return userRepository.findById(id).map(user -> {
            userRepository.deleteById(id);
            return UserMapper.toUserResponseDTO(user);
        });
    }
}
