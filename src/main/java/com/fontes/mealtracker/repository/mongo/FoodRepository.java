package com.fontes.mealtracker.repository.mongo;

import com.fontes.mealtracker.model.Food;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FoodRepository extends MongoRepository<Food, String> {
    Optional<Food> findByName(String name);
}
