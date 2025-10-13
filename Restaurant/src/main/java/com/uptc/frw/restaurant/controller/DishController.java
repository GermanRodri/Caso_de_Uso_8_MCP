package com.uptc.frw.restaurant.controller;

import com.uptc.frw.restaurant.model.Dish;
import com.uptc.frw.restaurant.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping
    public List<Dish> getAllDish(){
        return dishService.getAllDish();
    }

    @GetMapping("/{id}")
    public Dish getDishById(@PathVariable long id){
        return dishService.getDishById(id);
    }

    @PostMapping
    public Dish saveDish(@RequestBody Dish dish){
        return dishService.saveDish(dish);
    }

    @PutMapping
    public Dish updateDish(@RequestBody Dish dish){
        return dishService.updateDish(dish);
    }

    @DeleteMapping
    public void deleteDish(@RequestParam long id){
        dishService.deleteDish(id);
    }
}
