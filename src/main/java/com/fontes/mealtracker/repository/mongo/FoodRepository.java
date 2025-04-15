package com.fontes.mealtracker.repository.mongo;

import com.fontes.mealtracker.model.Food;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodRepository extends MongoRepository<Food, String> {
}
