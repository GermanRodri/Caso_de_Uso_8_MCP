package com.uptc.frw.restaurant.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "VENTAS")
public class Sale {
    @Id
    @Column(name = "ID_VENTA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "FECHA_VENTA")
    private Date date;

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

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
