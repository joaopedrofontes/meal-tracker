package com.fontes.mealtracker.controller;


import com.fontes.mealtracker.dto.meal.MealMapper;
import com.fontes.mealtracker.dto.meal.MealRequestDTO;
import com.fontes.mealtracker.dto.meal.MealResponseDTO;
import com.fontes.mealtracker.model.Meal;
import com.fontes.mealtracker.service.MealService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public MealResponseDTO createMeal(@RequestBody @Valid MealRequestDTO dto) {
        Meal meal = MealMapper.toEntity(dto);
        Meal saved = mealService.save(meal);
        return MealMapper.toMealResponseDTO(saved);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MealResponseDTO> getMeal(@PathVariable UUID id) {
        return mealService.findById(id)
                .map(MealMapper::toMealResponseDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
