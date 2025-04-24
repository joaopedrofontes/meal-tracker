package com.fontes.mealtracker.repository.postgres;


import com.fontes.mealtracker.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MealRepository extends JpaRepository<Meal, UUID> {

    @Query("SELECT m FROM Meal m WHERE m.user.id = :userId")
    List<Meal> findAllByUserId(@Param("userId") UUID userId);
}
