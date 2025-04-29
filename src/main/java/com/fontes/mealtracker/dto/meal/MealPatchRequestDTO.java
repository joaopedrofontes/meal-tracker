package com.fontes.mealtracker.dto.meal;

import com.fontes.mealtracker.model.User;

import java.time.ZonedDateTime;

public record MealPatchRequestDTO (
    User user,
    String name,
    ZonedDateTime date
) {}

