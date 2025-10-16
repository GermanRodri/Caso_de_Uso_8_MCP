package com.uptc.frw.restaurant.controller;

import com.uptc.frw.restaurant.model.Dish;
import com.uptc.frw.restaurant.model.DishMenu;
import com.uptc.frw.restaurant.model.Menu;
import com.uptc.frw.restaurant.model.key.DishMenuKey;
import com.uptc.frw.restaurant.service.DishMenuService;
import com.uptc.frw.restaurant.service.DishService;
import com.uptc.frw.restaurant.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dish-menus")
public class DishMenuController {

    @Autowired
    private DishMenuService dishMenuService;
    @Autowired
    private DishService dishService;
    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<DishMenu> getAll() {
        return dishMenuService.findAllDishMenu();
    }

    @GetMapping("/{idmenu}/{iddish}")
    public DishMenu getDishMenuById(@PathVariable long idmenu, @PathVariable long iddish) {
        Dish dish = dishService.getDishById(iddish);
        Menu menu = menuService.getMenuId(idmenu);

        if (dish == null || menu == null) {
            throw new RuntimeException("Plato o menu no encontrado");
        }

        DishMenuKey  dishMenuKey = new DishMenuKey(dish,menu);
        return dishMenuService.findDishMenuById(dishMenuKey);
    }

    @PostMapping
    public DishMenu saveDishMenu(@RequestBody DishMenu dishMenu) {
        return dishMenuService.saveDishMenu(dishMenu);
    }

    @PutMapping
    public DishMenu updateDishMenu(@RequestBody DishMenu dishMenu) {
        return dishMenuService.updateDishMenu(dishMenu);
    }

    @DeleteMapping
    public void deleteDishMenu(@RequestParam Long idmenu, @RequestParam Long iddish) {
        Dish dish = dishService.getDishById(iddish);
        Menu menu = menuService.getMenuId(idmenu);

        if (dish == null || menu == null) {
            throw new RuntimeException("Plato o menu no encontrado");
        }

        DishMenuKey  dishMenuKey = new DishMenuKey(dish,menu);

        // Verificar si el registro existe antes de eliminarlo
        DishMenu existingDishMenu = dishMenuService.findDishMenuById(dishMenuKey);
        if (existingDishMenu == null) {
            throw new RuntimeException("La relación plato-menu no existe");
        }

        dishMenuService.deleteDishMenu(dishMenuKey);
    }
}
