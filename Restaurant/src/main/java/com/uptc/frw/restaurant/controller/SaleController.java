package com.uptc.frw.restaurant.controller;

import com.uptc.frw.restaurant.model.Sale;
import com.uptc.frw.restaurant.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<Sale> getAllSales(){
        return saleService.getAllSales();
    }

    @GetMapping("/{id}")
    public Sale getSaleById(@PathVariable long id){
        return saleService.getSaleById(id);
    }

    @PostMapping
    public Sale saveSale(@RequestBody Sale sale){
        return saleService.saveSale(sale);
    }

    @PutMapping
    public Sale updateSale(@RequestBody Sale sale){
        return saleService.updateSale(sale);
    }

    @DeleteMapping
    public void deleteSale(@RequestParam long id){
        saleService.deleteSale(id);
    }
}
