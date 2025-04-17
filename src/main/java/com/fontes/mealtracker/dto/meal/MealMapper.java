package com.fontes.mealtracker.dto.meal;


import com.fontes.mealtracker.model.Meal;
import com.fontes.mealtracker.model.User;

import java.time.ZonedDateTime;

public class MealMapper {

    public static Meal toEntity(MealRequestDTO dto) {
        Meal meal = new Meal();
        meal.setName(dto.getName());
        meal.setDate(dto.getDate());
        meal.setCreatedAt(ZonedDateTime.now());

        User user = new User();
        user.setId(dto.getUserId());
        meal.setUser(user);

        return meal;
    }

    public static MealResponseDTO toMealResponseDTO(Meal meal) {
        return new MealResponseDTO(
                meal.getMealId(),
                meal.getUser().getId(),
                meal.getName(),
                meal.getDate()
        );
    }
}
