package com.fontes.mealtracker.controller;

import com.fontes.mealtracker.dto.mealFood.MealFoodMapper;
import com.fontes.mealtracker.dto.mealFood.MealFoodRequestDTO;
import com.fontes.mealtracker.dto.mealFood.MealFoodResponseDTO;
import com.fontes.mealtracker.model.MealFood;
import com.fontes.mealtracker.service.MealFoodService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public MealFoodResponseDTO createMealFood(@RequestBody @Valid MealFoodRequestDTO dto) {
        MealFood mealFood = MealFoodMapper.toEntity(dto);
        MealFood saved = mealFoodService.save(mealFood);
        return MealFoodMapper.toMealFoodResponseDTO(saved);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MealFoodResponseDTO> getMealFood(@PathVariable UUID id) {
        return mealFoodService.findById(id)
                .map(MealFoodMapper::toMealFoodResponseDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
