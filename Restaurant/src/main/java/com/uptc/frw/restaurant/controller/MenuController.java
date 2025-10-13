package com.uptc.frw.restaurant.controller;

import com.uptc.frw.restaurant.model.Menu;
import com.uptc.frw.restaurant.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("menus")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @GetMapping
    public List<Menu> getAllMenus(){
        return menuService.findAllMenu();
    }
    @GetMapping("/{id}")
    public Menu getMenu(@PathVariable long id){
        return menuService.getMenuId(id);
    }
    @PostMapping
    public Menu saveMenu(@RequestBody Menu menu){
        return menuService.saveMenu(menu);
    }
    @PutMapping
    public Menu updateMenu(@RequestBody Menu menu){
        return menuService.updateMenu(menu);
    }
    @DeleteMapping
    public void deleteMenu(@RequestParam long id){
        System.out.println(id);
        menuService.deleteMenu(id);
    }
}