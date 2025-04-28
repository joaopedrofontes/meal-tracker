package com.fontes.mealtracker.dto.user;


import com.fontes.mealtracker.model.User;
import com.fontes.mealtracker.security.UserRole;

import java.time.ZonedDateTime;

public class UserMapper {

    public static User toEntity(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setCreatedAt(ZonedDateTime.now());
        user.setRole(UserRole.USER);
        return user;
    }

    public static UserResponseDTO toUserResponseDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
