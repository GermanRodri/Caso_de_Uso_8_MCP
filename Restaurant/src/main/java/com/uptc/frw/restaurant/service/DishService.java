package com.uptc.frw.restaurant.service;

import com.uptc.frw.restaurant.model.Dish;
import com.uptc.frw.restaurant.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;

    public List<Dish> getAllDish(){
        return dishRepository.findAll();
    }

    public Dish getDishById(long id){
        Dish dish = dishRepository.findById(id).orElse(null);
        return dish;
    }

    public Dish saveDish(Dish dish){
        Dish dishNew = dishRepository.save(dish);
        return dishNew;
    }

    public Dish updateDish(Dish dish){
        Dish dishNew = getDishById(dish.getId());
        if (dishNew != null){
            dishNew.setDishType(dish.getDishType());
            dishNew.setName(dish.getName());
            dishNew.setDescription(dish.getDescription());
            saveDish(dishNew);
            return dishNew;
        }else{
            throw new RuntimeException("El plato no existe");
        }
    }

    public void deleteDish(long id){
        dishRepository.deleteById(id);
    }
}
