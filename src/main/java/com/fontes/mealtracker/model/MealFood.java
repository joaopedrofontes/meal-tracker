package com.fontes.mealtracker.model;


import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "meal_foods")
public class MealFood {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "meal_food_id")
    private UUID mealFoodId;

    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    private Meal meal;

    @Column(name = "food_id")
    private String foodId;

    @Column(name = "quantity_in_grams")
    private float quantityInGrams;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    public UUID getId() {
        return mealFoodId;
    }

    public void setId(UUID mealFoodId) {
        this.mealFoodId = mealFoodId;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
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

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
