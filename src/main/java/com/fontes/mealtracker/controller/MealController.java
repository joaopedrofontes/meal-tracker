package com.fontes.mealtracker.controller;


import com.fontes.mealtracker.model.Meal;
import com.fontes.mealtracker.service.MealService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/meal")
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping
    public Meal createMeal(@RequestBody Meal meal) {
        return mealService.save(meal);
    }

    @GetMapping(value = "/{id}")
    public Meal getMeal(@PathVariable UUID id) {
        return mealService.findById(id).orElse(null);
    }

    
}
