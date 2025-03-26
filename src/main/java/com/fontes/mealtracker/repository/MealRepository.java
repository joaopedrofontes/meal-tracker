package com.fontes.mealtracker.repository;


import com.fontes.mealtracker.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MealRepository extends JpaRepository<Meal, UUID> {

}
