package com.fontes.mealtracker.controller;


import com.fontes.mealtracker.dto.meal.MealMapper;
import com.fontes.mealtracker.dto.meal.MealRequestDTO;
import com.fontes.mealtracker.dto.meal.MealResponseDTO;
import com.fontes.mealtracker.model.Meal;
import com.fontes.mealtracker.service.MealService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/meal")
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping
    public ResponseEntity<MealResponseDTO> createMeal(@RequestBody @Valid MealRequestDTO dto) {
        MealResponseDTO response = mealService.save(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MealResponseDTO> getMeal(@PathVariable UUID id) {
        return mealService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<List<MealResponseDTO>> getMealByUserId(@PathVariable UUID userId) {
        List<MealResponseDTO> response = mealService.findByUserId(userId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MealResponseDTO> deleteMeal(@PathVariable UUID id) {
        return mealService.deleteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
