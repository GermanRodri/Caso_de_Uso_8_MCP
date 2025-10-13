package com.uptc.frw.restaurant.controller;

import com.uptc.frw.restaurant.model.SaleMenu;
import com.uptc.frw.restaurant.service.SaleMenuService;
import com.uptc.frw.restaurant.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("SalesMenu")
public class SaleMenuController {

    @Autowired
    private SaleService saleService;
    @Autowired
    private SaleMenuService saleMenuService;

    @GetMapping
    public List<SaleMenu> getAllSalesMenu(){
        return saleMenuService.findAllSaleMenuService();
    }
    @PostMapping
    public SaleMenu saveSaleMenu(@RequestBody SaleMenu saleMenu){
        return saleMenuService.saveSaleMenu(saleMenu);
    }
    @PutMapping
    public SaleMenu updateSaleMenu(@RequestBody SaleMenu saleMenu){
        return saleMenuService.updateSalesMenu(saleMenu);
    }
    @DeleteMapping
    public void deleteSaleMenu(long id){
        System.out.println(id);
        saleMenuService.deleteSaleMenu(id);
    }
}
