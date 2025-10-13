package com.uptc.frw.restaurant.service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas_menus")
public class SaleMenuService {

    @Id
    @Column(name = "id_ventas_menu")
    private int idSaleMenu;
    @Column(name = "id_menu")
    private int idSale;
    @Column(name = "id_menu")
    private int idMenu;
    @Column(name = "cantidad")
    private long quantity;

    public SaleMenuService() {
    }

    public int getIdSaleMenu() {
        return idSaleMenu;
    }

    public void setIdSaleMenu(int idSaleMenu) {
        this.idSaleMenu = idSaleMenu;
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SaleMenuService{" +
                "idSaleMenu=" + idSaleMenu +
                ", idSale=" + idSale +
                ", idMenu=" + idMenu +
                ", quantity=" + quantity +
                '}';
    }
}
