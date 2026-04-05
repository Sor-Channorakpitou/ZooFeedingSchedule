package com.zoo.services;

import com.zoo.dao.FoodDAO;
import com.zoo.exceptions.ZooException;
import com.zoo.models.Food;
import java.util.List;

public class FoodService {

    private final List<Food> foodInventory;
    private final FoodDAO foodDAO;

    public FoodService(List<Food> foodInventory, FoodDAO foodDAO) {
        this.foodInventory = foodInventory;
        this.foodDAO = foodDAO;
    }

    // CRUD                                                                
    public void addFoodToInventory(Food food) throws ZooException {
        foodDAO.addFood(food);
        foodInventory.add(food);
    }

    public void removeFoodFromInventory(int id) throws ZooException {
        foodDAO.deleteFood(id);
        foodInventory.removeIf(f -> f.getId() == id);
    }
}