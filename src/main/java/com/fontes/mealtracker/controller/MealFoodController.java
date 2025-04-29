package com.fontes.mealtracker.controller;

import com.fontes.mealtracker.dto.mealFood.MealFoodPatchRequestDTO;
import com.fontes.mealtracker.dto.mealFood.MealFoodRequestDTO;
import com.fontes.mealtracker.dto.mealFood.MealFoodResponseDTO;
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
    public ResponseEntity<MealFoodResponseDTO> createMealFood(@RequestBody @Valid MealFoodRequestDTO dto) {
        MealFoodResponseDTO response = mealFoodService.save(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MealFoodResponseDTO> getMealFood(@PathVariable UUID id) {
        return mealFoodService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MealFoodResponseDTO> updateMealFood(@PathVariable UUID id, @RequestBody @Valid MealFoodRequestDTO dto) {
        return mealFoodService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<MealFoodResponseDTO> patchMealFood(@PathVariable UUID id, @RequestBody @Valid MealFoodPatchRequestDTO dto) {
        return mealFoodService.patch(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MealFoodResponseDTO> deleteMealFood(@PathVariable UUID id) {
        return mealFoodService.deleteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
