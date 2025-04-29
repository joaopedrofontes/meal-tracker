package com.fontes.mealtracker.dto.mealFood;

import com.fontes.mealtracker.model.Meal;

public record MealFoodPatchRequestDTO(
        Meal meal,
        String foodId,
        Float quantityInGrams
) {
}
