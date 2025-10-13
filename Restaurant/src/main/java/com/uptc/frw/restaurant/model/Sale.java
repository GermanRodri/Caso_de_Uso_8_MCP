package com.uptc.frw.restaurant.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "VENTAS")
public class Sale {
    @Id
    @Column(name = "ID_VENTA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "FECHA_VENTA")
    private Date date;
    @OneToMany(mappedBy = "sale")
    private List<SaleMenu> saleMenus;

    public Sale() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<SaleMenu> getSaleMenus() {
        return saleMenus;
    }

    public void setSaleMenus(List<SaleMenu> saleMenus) {
        this.saleMenus = saleMenus;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
