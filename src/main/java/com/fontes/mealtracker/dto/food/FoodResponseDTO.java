package com.fontes.mealtracker.dto.food;

import java.util.Map;

public record FoodResponseDTO(

    String id,
    String name,
    double calories,
    double protein,
    double carbohydrate,
    double fat,
    Map<String, Object> additionalInfo
) {}
