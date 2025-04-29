package com.fontes.mealtracker.dto.mealFood;

import com.fontes.mealtracker.model.Meal;

public record MealFoodPatchRequest(
        Meal meal,
        String foodId,
        float quantityInGrams
) {
}
