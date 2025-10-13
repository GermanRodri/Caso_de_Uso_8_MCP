package com.uptc.frw.restaurant.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "VENTAS_MENU")
public class SaleMenu {

    @Id
    @Column(name = "ID_VENTAS_MENU")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSaleMenu;
    @Column(name = "ID_SALE", insertable = false, updatable = false)
    private int idSale;
    @Column(name = "ID_MENU", insertable = false, updatable = false)
    private int idMenu;
    @Column(name = "CANTIDAD")
    private long quantity;
    @ManyToOne
    @JoinColumn(name = "ID_MENU")
    private Menu menu;
    @ManyToOne
    @JoinColumn(name = "ID_SALE")
    private Sale sale;

    public SaleMenu() {
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
                "idSaleMenu=" + idSaleMenu +
                ", idSale=" + idSale +
                ", idMenu=" + idMenu +
                ", quantity=" + quantity +
                '}';
    }
}
