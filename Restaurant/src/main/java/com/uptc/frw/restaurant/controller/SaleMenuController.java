package com.uptc.frw.restaurant.controller;

import com.uptc.frw.restaurant.model.Menu;
import com.uptc.frw.restaurant.model.Sale;
import com.uptc.frw.restaurant.model.SaleMenu;
import com.uptc.frw.restaurant.model.key.SaleMenuKey;
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
    @GetMapping("/{idMenu}/{idSale}")
    public SaleMenu saleMenu(@PathVariable long idMenu, @PathVariable long idSale){
        SaleMenuKey saleMenuKey = new SaleMenuKey();
        Menu menu = new Menu();
        menu.setIdMenu(idMenu);
        Sale sale = new Sale();
        sale.setId(idSale);
        saleMenuKey.setMenu(menu);
        saleMenuKey.setSale(sale);
        return saleMenuService.findSaleMenuById(saleMenuKey);
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
    public void deleteSaleMenu(@RequestParam long idSale, @RequestParam long idMenu){
        SaleMenuKey saleMenuKey = new SaleMenuKey();
        Menu menu = new Menu();
        menu.setIdMenu(idMenu);
        Sale sale = new Sale();
        sale.setId(idSale);
        saleMenuKey.setMenu(menu);
        saleMenuKey.setSale(sale);
        saleMenuService.deleteSaleMenu(saleMenuKey);
    }
}
