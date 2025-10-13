package com.uptc.frw.restaurant.model.key;

import com.uptc.frw.restaurant.model.Menu;
import com.uptc.frw.restaurant.model.Sale;

import java.io.Serializable;

public class SaleMenuKey implements Serializable {
    private Sale sale;
    private Menu menu;

    public SaleMenuKey() {
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
