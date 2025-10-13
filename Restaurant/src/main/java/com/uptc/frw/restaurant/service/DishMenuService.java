package com.uptc.frw.restaurant.service;

import com.uptc.frw.restaurant.model.DishMenu;
import com.uptc.frw.restaurant.model.key.DishMenuKey;
import com.uptc.frw.restaurant.repository.DishMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishMenuService {
    @Autowired
    private DishMenuRepository dishMenuRepository;

    public List<DishMenu> findAllDishMenu() {
        return dishMenuRepository.findAll();
    }

    public DishMenu findDishMenuById(DishMenuKey key) {
        return dishMenuRepository.findById(key).orElse(null);
    }

    public DishMenu saveDishMenu(DishMenu dishMenu) {
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
