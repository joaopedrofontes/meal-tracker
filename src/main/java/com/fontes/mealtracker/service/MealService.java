package com.fontes.mealtracker.service;


import com.fontes.mealtracker.dto.meal.MealMapper;
import com.fontes.mealtracker.dto.meal.MealRequestDTO;
import com.fontes.mealtracker.dto.meal.MealResponseDTO;
import com.fontes.mealtracker.model.Meal;
import com.fontes.mealtracker.model.User;
import com.fontes.mealtracker.repository.postgres.MealRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public List<MealResponseDTO> findByUserId(UUID userId) {
        List<Meal> meals = mealRepository.findAllByUserId(userId);
        return meals.stream()
                .map(MealMapper::toMealResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<MealResponseDTO> update(UUID id, MealRequestDTO dto) {
        return mealRepository.findById(id)
                .map(meal -> {
                    User user = new User();
                    user.setId(dto.getUserId());
                    meal.setUser(user);
                    meal.setName(dto.getName());
                    meal.setDate(dto.getDate());

                    Meal updated = mealRepository.save(meal);
                    return MealMapper.toMealResponseDTO(updated);
                });
    }

    public Optional<MealResponseDTO> deleteById(UUID id) {
        return mealRepository.findById(id).map(meal -> {
            mealRepository.deleteById(id);
            return MealMapper.toMealResponseDTO(meal);
        });
    }
}
