package com.fontes.mealtracker.controller;

import com.fontes.mealtracker.dto.food.FoodRequestDTO;
import com.fontes.mealtracker.dto.food.FoodResponseDTO;
import com.fontes.mealtracker.service.FoodService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/food")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public ResponseEntity<FoodResponseDTO> createFood(@RequestBody  @Valid FoodRequestDTO dto) {
        FoodResponseDTO response = foodService.save(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value=  "/{id}")
    public ResponseEntity<FoodResponseDTO> getFood(@PathVariable String id) {
        return foodService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FoodResponseDTO> deleteFood(@PathVariable String id) {
        return foodService.deleteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
