package com.uptc.frw.restaurant.service;

import com.uptc.frw.restaurant.model.Sale;
import com.uptc.frw.restaurant.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> getAllSales(){
        return saleRepository.findAll();
    }

    public Sale getSaleById(long id){
        Sale saleNew = saleRepository.findById(id).orElse(null);
        return saleNew;
    }

    public Sale saveSale(Sale sale){
        Sale saleNew = saleRepository.save(sale);
        return saleNew;
    }

    public Sale updateSale(Sale sale){
        Sale saleNew = getSaleById(sale.getId());
        if (saleNew != null){
            saleNew.setDate(sale.getDate());
            saveSale(saleNew);
            return saleNew;
        }else{
            throw new RuntimeException("La venta no existe");
        }
    }

    public void deleteSale(long id){
        saleRepository.deleteById(id);
    }
}
