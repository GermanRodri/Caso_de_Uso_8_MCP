package com.uptc.frw.restaurant.controller;

import com.uptc.frw.restaurant.model.Menu;
import com.uptc.frw.restaurant.model.Sale;
import com.uptc.frw.restaurant.model.SaleMenu;
import com.uptc.frw.restaurant.service.MenuService;
import com.uptc.frw.restaurant.service.SaleMenuService;
import com.uptc.frw.restaurant.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("SalesMenu")
public class SaleMenuController {

    @Autowired
    private SaleMenuService saleMenuService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<SaleMenu> getAllSalesMenu(){
        return saleMenuService.findAllSaleMenuService();
    }
    @GetMapping("/{id}/{id1}")
    public SaleMenu saleMenu(@PathVariable long id, @PathVariable long id1){
        Menu menu = menuService.getMenuId(id);
        Sale sale = saleService.getSaleById(id1);
        return saleMenuService.findSaleMenuById(id,id1);
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
