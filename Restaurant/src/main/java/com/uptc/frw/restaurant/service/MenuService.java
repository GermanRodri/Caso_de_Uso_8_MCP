package com.uptc.frw.restaurant.service;

import com.uptc.frw.restaurant.model.Menu;
import com.uptc.frw.restaurant.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> findAllMenu(){
        return menuRepository.findAll();
    }
    public Menu getMenuId(long id){
        Menu menu = menuRepository.findById(id).orElse(null);
        return menu;
    }
    public Menu saveMenu(Menu menu){
        Menu menuNew = menuRepository.save(menu);
        return menuNew;
    }
    public Menu updateMenu(Menu menu){
        Menu menu1 = getMenuId(menu.getIdMenu());
        if (menu1 != null) {
            menu1.setDescription(menu.getDescription());
            saveMenu(menu1);
            return menu1;
        }
        else {
            throw new RuntimeException("El registro no existe");
        }
    }
    public void deleteMenu(Long id){
        menuRepository.deleteById(id);
    }
}
