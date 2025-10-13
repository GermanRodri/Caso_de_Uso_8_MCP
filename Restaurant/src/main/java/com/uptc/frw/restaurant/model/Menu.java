package com.uptc.frw.restaurant.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "MENUS")
public class Menu {
    @Id
    @Column(name = "ID_MENU")
    private long idMenu;
    @Column(name = "DESCRIPCION_MENU")
    private String description;
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

    @Override
    public String toString() {
        return "Menu{" +
                "idMenu=" + idMenu +
                ", description='" + description + '\'' +
                '}';
    }
}
