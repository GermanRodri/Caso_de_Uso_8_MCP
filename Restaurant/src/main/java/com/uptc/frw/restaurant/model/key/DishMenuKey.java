package com.uptc.frw.restaurant.model.key;

import com.uptc.frw.restaurant.model.Dish;
import com.uptc.frw.restaurant.model.Menu;

import java.io.Serializable;

public class DishMenuKey implements Serializable {
    private Dish dish;
    private Menu menu;

    public DishMenuKey() {}

    public DishMenuKey(Dish dish, Menu menu) {
        this.dish = dish;
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }
}
