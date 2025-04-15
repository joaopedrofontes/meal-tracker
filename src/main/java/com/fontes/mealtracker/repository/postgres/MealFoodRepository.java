package com.fontes.mealtracker.repository.postgres;

import com.fontes.mealtracker.model.MealFood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MealFoodRepository extends JpaRepository<MealFood, UUID> {
}
