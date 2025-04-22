package com.fontes.mealtracker.dto.food;

import com.fontes.mealtracker.model.Food;

public class FoodMapper {

    public static Food toEntity(FoodRequestDTO dto) {
        Food food = new Food();
        food.setName(dto.getName());
        food.setCalories(dto.getCalories());
        food.setProtein(dto.getProtein());
        food.setCarbohydrate(dto.getCarbohydrate());
        food.setFat(dto.getFat());
        food.setAdditionalInfo(dto.getAdditionalInfo());

        return food;
    }

    public static FoodResponseDTO toFoodResponseDTO(Food food) {
        return new FoodResponseDTO(
                food.getId(),
                food.getName(),
                food.getCalories(),
                food.getProtein(),
                food.getCarbohydrate(),
                food.getFat(),
                food.getAdditionalInfo()
        );
    }
}
