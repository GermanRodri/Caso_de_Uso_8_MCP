package com.uptc.frw.restaurant.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "MENUS")
public class Menu {
    @Id
    @Column(name = "ID_MENU")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMenu;
    @Column(name = "DESCRIPCION_MENU")
    private String description;
    @OneToMany(mappedBy = "salesMenus", cascade = {CascadeType.PERSIST})
    private List<SaleMenu> saleMenus;
    @OneToMany(mappedBy = "dishesMenus", cascade = {CascadeType.PERSIST})
    private List<DishMenu> dishesMenus;
    public Menu() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(long idMenu) {
        this.idMenu = idMenu;
    }

    public List<SaleMenu> getSaleMenus() {
        return saleMenus;
    }

    public void setSaleMenus(List<SaleMenu> saleMenus) {
        this.saleMenus = saleMenus;
    }

    public List<DishMenu> getDishesMenus() {
        return dishesMenus;
    }

    public void setDishesMenus(List<DishMenu> dishesMenus) {
        this.dishesMenus = dishesMenus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "idMenu=" + idMenu +
                ", description='" + description + '\'' +
                '}';
    }
}
