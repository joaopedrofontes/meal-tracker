package com.fontes.mealtracker.service;


import com.fontes.mealtracker.dto.meal.MealMapper;
import com.fontes.mealtracker.dto.meal.MealRequestDTO;
import com.fontes.mealtracker.dto.meal.MealResponseDTO;
import com.fontes.mealtracker.model.Meal;
import com.fontes.mealtracker.repository.postgres.MealRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MealService {

    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public MealResponseDTO save(MealRequestDTO dto) {
        Meal meal = MealMapper.toEntity(dto);
        Meal saved = mealRepository.save(meal);
        return MealMapper.toMealResponseDTO(saved);
    }

    public Optional<MealResponseDTO> findById(UUID id) {
        return mealRepository.findById(id)
                .map(MealMapper::toMealResponseDTO);
    }

    public void deleteById(UUID id) {
        mealRepository.deleteById(id);
    }
}
