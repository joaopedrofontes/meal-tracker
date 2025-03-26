package com.fontes.mealtracker.controller;

import com.fontes.mealtracker.model.MealFood;
import com.fontes.mealtracker.service.MealFoodService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/mealfood")
public class MealFoodController {

    private final MealFoodService mealFoodService;

    public MealFoodController(MealFoodService mealFoodService) {
        this.mealFoodService = mealFoodService;
    }

    @PostMapping
    public MealFood createMealFood(@RequestBody MealFood mealFood) {
        return mealFoodService.save(mealFood);
    }

    @GetMapping(value = "/{id}")
    public MealFood getMealFood(@PathVariable UUID id) {
        return mealFoodService.findById(id).orElse(null);
    }

}
