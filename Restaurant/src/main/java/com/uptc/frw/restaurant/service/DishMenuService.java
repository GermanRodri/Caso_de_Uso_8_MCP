package com.uptc.frw.restaurant.service;

import com.uptc.frw.restaurant.model.Dish;
import com.uptc.frw.restaurant.model.DishMenu;
import com.uptc.frw.restaurant.model.Menu;
import com.uptc.frw.restaurant.model.key.DishMenuKey;
import com.uptc.frw.restaurant.repository.DishMenuRepository;
import com.uptc.frw.restaurant.repository.DishRepository;
import com.uptc.frw.restaurant.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishMenuService {
    @Autowired
    private DishMenuRepository dishMenuRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private MenuRepository menuRepository;

    public List<DishMenu> findAllDishMenu() {
        return dishMenuRepository.findAll();
    }

    public DishMenu findDishMenuById(DishMenuKey key) {
        return dishMenuRepository.findById(key).orElse(null);
    }

    public DishMenu saveDishMenu(DishMenu dishMenu) {
        Dish dish = dishRepository.findById(dishMenu.getIdDish()).get();
        dishMenu.setDish(dish);
        Menu menu = menuRepository.findById(dishMenu.getIdMenu()).get();
        dishMenu.setMenu(menu);
        return dishMenuRepository.save(dishMenu);
    }

    public DishMenu updateDishMenu(DishMenu dishMenu){
        DishMenuKey dishMenuKey = new DishMenuKey(dishMenu.getDish(),dishMenu.getMenu());
        DishMenu newDishMenu = findDishMenuById(dishMenuKey);

        if(newDishMenu == null){
            throw new RuntimeException("Plato de menu no encontrado");
        }
        newDishMenu.setDate(dishMenu.getDate());
        newDishMenu.setPrice(dishMenu.getPrice());

        return saveDishMenu(newDishMenu);
    }

    public void deleteDishMenu(DishMenuKey key){
        dishMenuRepository.deleteById(key);
    }
}
