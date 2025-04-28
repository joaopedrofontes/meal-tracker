package com.fontes.mealtracker.dto.user;

import com.fontes.mealtracker.security.UserRole;

public record UserUpdateDTO(
        String name,
        String email,
        String password,
        UserRole role
) {}
