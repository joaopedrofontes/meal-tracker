package com.fontes.mealtracker.dto.mealFood;

import com.fontes.mealtracker.model.MealFood;

import java.time.ZonedDateTime;

public class MealFoodMapper {

    public static MealFood toEntity(MealFoodRequestDTO dto) {
        MealFood mealFood = new MealFood();
        mealFood.setFoodId(dto.getFoodId());
        mealFood.setQuantityInGrams(dto.getQuantityInGrams());
        mealFood.setCreatedAt(ZonedDateTime.now());

        return mealFood;
    }

    public static MealFoodResponseDTO toMealFoodResponseDTO(MealFood mealFood) {
        return new MealFoodResponseDTO(
                mealFood.getId(),
                mealFood.getMealId(),
                mealFood.getFoodId(),
                mealFood.getQuantityInGrams()
        );
    }
}
