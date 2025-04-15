package com.fontes.mealtracker.dto.user;

import java.util.UUID;

public record UserResponseDTO (
        UUID id,
        String name,
        String email
) {}
