package com.fontes.mealtracker.dto.mealFood;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public class MealFoodRequestDTO {
    @NotNull
    private UUID mealId;

    @NotBlank
    private String foodId;

    @Positive
    private float quantityInGrams;

    public UUID getMealId() {
        return mealId;
    }

    public void setMealId(UUID mealId) {
        this.mealId = mealId;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public float getQuantityInGrams() {
        return quantityInGrams;
    }

    public void setQuantityInGrams(float quantityInGrams) {
        this.quantityInGrams = quantityInGrams;
    }

}
