package com.fontes.mealtracker.service;


import com.fontes.mealtracker.dto.user.UserMapper;
import com.fontes.mealtracker.dto.user.UserRequestDTO;
import com.fontes.mealtracker.dto.user.UserResponseDTO;
import com.fontes.mealtracker.model.User;
import com.fontes.mealtracker.repository.postgres.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO save(UserRequestDTO dto) {
        User user = UserMapper.toEntity(dto);
        User saved = userRepository.save(user);
        return UserMapper.toUserResponseDTO(saved);
    }

    public Optional<UserResponseDTO> findById(UUID id) {
        return userRepository.findById(id)
                .map(UserMapper::toUserResponseDTO);
    }

    public Optional<UserResponseDTO> deleteById(UUID id) {
        return userRepository.findById(id).map(user -> {
            userRepository.deleteById(id);
            return UserMapper.toUserResponseDTO(user);
        });
    }
}
