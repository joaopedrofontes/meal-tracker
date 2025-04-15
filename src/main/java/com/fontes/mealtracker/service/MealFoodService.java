package com.fontes.mealtracker.service;

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

    public MealFood save(MealFood mealFood) {
        return mealFoodRepository.save(mealFood);
    }

    public Optional<MealFood> findById(UUID id) {
        return mealFoodRepository.findById(id);
    }

    public void deleteById(UUID id) {
        mealFoodRepository.deleteById(id);
    }

}
