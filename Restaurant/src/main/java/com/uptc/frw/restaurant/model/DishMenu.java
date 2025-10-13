package com.uptc.frw.restaurant.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
@Entity
@Table(name = "PLATOS_MENU")
public class DishMenu {
    @Id
    @Column(name = "ID_MENU")
    private Long idMenu;
    @Column(name = "ID_PLATO")
    private Long idDish;
    @Column(name = "PRECIO")
    private Double price;
    @Column(name = "FECHA")
    private Date date;

    public DishMenu() {
    }

    public long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(long idMenu) {
        this.idMenu = idMenu;
    }

    public long getIdDish() {
        return idDish;
    }

    public void setIdDish(long idDish) {
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
