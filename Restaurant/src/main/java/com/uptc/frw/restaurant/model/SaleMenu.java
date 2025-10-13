package com.uptc.frw.restaurant.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "VENTAS_MENU")
public class SaleMenu {

    @Column(name = "ID_SALE", insertable = false, updatable = false)
    private long idSale;
    @Column(name = "ID_MENU", insertable = false, updatable = false)
    private long idMenu;
    @Column(name = "CANTIDAD")
    private long quantity;
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_MENU")
    private Menu menu;
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_SALE")
    private Sale sale;

    public SaleMenu() {
    }

    public long getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public long getIdMenu() {
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "SaleMenu{" +
                ", idSale=" + idSale +
                ", idMenu=" + idMenu +
                ", quantity=" + quantity +
                '}';
    }
}
