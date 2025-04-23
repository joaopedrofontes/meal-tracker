package com.fontes.mealtracker.service;

import com.fontes.mealtracker.dto.mealFood.MealFoodMapper;
import com.fontes.mealtracker.dto.mealFood.MealFoodRequestDTO;
import com.fontes.mealtracker.dto.mealFood.MealFoodResponseDTO;
import com.fontes.mealtracker.model.MealFood;
import com.fontes.mealtracker.repository.postgres.MealFoodRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MealFoodService {

    private final MealFoodRepository mealFoodRepository;

    public MealFoodService(MealFoodRepository mealFoodRepository) {
        this.mealFoodRepository = mealFoodRepository;
    }

    public MealFoodResponseDTO save(MealFoodRequestDTO dto) {
        MealFood mealFood = MealFoodMapper.toEntity(dto);
        MealFood saved = mealFoodRepository.save(mealFood);
        return MealFoodMapper.toMealFoodResponseDTO(saved);
    }

    public Optional<MealFoodResponseDTO> findById(UUID id) {
        return mealFoodRepository.findById(id)
                .map(MealFoodMapper::toMealFoodResponseDTO);
    }

    public Optional<MealFoodResponseDTO> deleteById(UUID id) {
        return mealFoodRepository.findById(id).map(mealFood -> {
            mealFoodRepository.deleteById(id);
            return MealFoodMapper.toMealFoodResponseDTO(mealFood);
        });
    }

}
