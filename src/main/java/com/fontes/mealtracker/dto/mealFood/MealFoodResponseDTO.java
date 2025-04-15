package com.fontes.mealtracker.dto.mealFood;

import java.util.UUID;

public record MealFoodResponseDTO (
        UUID id,
        UUID mealId,
        String foodId,
        float quantityInGrams
){}
