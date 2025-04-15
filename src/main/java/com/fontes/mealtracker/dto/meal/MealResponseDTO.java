package com.fontes.mealtracker.dto.meal;

import java.time.ZonedDateTime;
import java.util.UUID;

public record MealResponseDTO (
        UUID mealId,
        UUID userId,
        String name,
        ZonedDateTime date
){}
