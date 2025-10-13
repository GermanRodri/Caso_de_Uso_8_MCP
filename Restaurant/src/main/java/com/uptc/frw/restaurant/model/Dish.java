package com.uptc.frw.restaurant.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PLATOS")
public class Dish {
    @Id
    @Column(name = "ID_PLATO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "TIPO_PLATO")
    private String dishType;
    @Column(name = "NOMBRE")
    private String name;
    @Column(name = "DESCRIPCION")
    private String description;
    @OneToMany(mappedBy = "dish")
    private List<DishMenu> dishMenuList;

    public Dish() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDishType() {
        return dishType;
    }

    public void setDishType(String dishType) {
        this.dishType = dishType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DishMenu> getDishMenuList() {
        return dishMenuList;
    }

    public void setDishMenuList(List<DishMenu> dishMenuList) {
        this.dishMenuList = dishMenuList;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", dishType='" + dishType + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
