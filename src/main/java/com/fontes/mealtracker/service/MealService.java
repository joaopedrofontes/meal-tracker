package com.fontes.mealtracker.service;


import com.fontes.mealtracker.model.Meal;
import com.fontes.mealtracker.repository.MealRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MealService {

    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public Meal save(Meal meal) {
        return mealRepository.save(meal);
    }

    public Optional<Meal> findById(UUID id) {
        return mealRepository.findById(id);
    }

    public void deleteById(UUID id) {
        mealRepository.deleteById(id);
    }
}
