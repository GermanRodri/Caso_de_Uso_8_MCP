package com.uptc.frw.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uptc.frw.restaurant.model.key.DishMenuKey;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "PLATOS_MENU")
@IdClass(DishMenuKey.class)
public class DishMenu {
    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "ID_MENU")
    @JsonIgnore
    private Menu menu;

    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "ID_PLATO")
    @JsonIgnore
    private Dish dish;

    @Column(name = "ID_MENU", insertable = false, updatable = false)
    private Long idMenu;

    @Column(name = "ID_PLATO", insertable = false, updatable = false)
    private Long idDish;

    @Column(name = "PRECIO")
    private Double price;

    @Column(name = "FECHA")
    private Date date;

    public DishMenu() {
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

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public Long getIdDish() {
        return idDish;
    }

    public void setIdDish(Long idDish) {
        this.idDish = idDish;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DishMenu{" +
                "idMenu=" + idMenu +
                ", idDish=" + idDish +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
