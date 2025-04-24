package com.fontes.mealtracker.service;

import com.fontes.mealtracker.dto.food.FoodMapper;
import com.fontes.mealtracker.dto.food.FoodRequestDTO;
import com.fontes.mealtracker.dto.food.FoodResponseDTO;
import com.fontes.mealtracker.model.Food;
import com.fontes.mealtracker.repository.mongo.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public FoodResponseDTO save(FoodRequestDTO dto) {
        Food food = FoodMapper.toEntity(dto);
        Food saved = foodRepository.save(food);
        return FoodMapper.toFoodResponseDTO(saved);
    }

    public Optional<FoodResponseDTO> findById(String id) {
        return foodRepository.findById(id)
                .map(FoodMapper::toFoodResponseDTO);
    }

    public Optional<FoodResponseDTO> findByName(String name) {
        return foodRepository.findByName(name)
                .map(FoodMapper::toFoodResponseDTO);
    }

    public Optional<FoodResponseDTO> deleteById(String id) {
        return foodRepository.findById(id).map(food -> {
            foodRepository.deleteById(id);
            return FoodMapper.toFoodResponseDTO(food);
        });
    }
}
