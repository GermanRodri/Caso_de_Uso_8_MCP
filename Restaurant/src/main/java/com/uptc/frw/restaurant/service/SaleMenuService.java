package com.uptc.frw.restaurant.service;


import com.uptc.frw.restaurant.model.Menu;
import com.uptc.frw.restaurant.model.Sale;
import com.uptc.frw.restaurant.model.SaleMenu;
import com.uptc.frw.restaurant.model.key.SaleMenuKey;
import com.uptc.frw.restaurant.repository.MenuRepository;
import com.uptc.frw.restaurant.repository.SaleMenuRepository;
import com.uptc.frw.restaurant.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleMenuService {
    @Autowired
    private SaleMenuRepository saleMenuRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private MenuService menuService;
    @Autowired
    private DishService dishService;
    @Autowired
    private SaleService saleService;

    public List<SaleMenu> findAllSaleMenuService(){
        return saleMenuRepository.findAll();
    }

    public SaleMenu findSaleMenuById(long idMenu, long idSale) {
        Menu menu = menuService.getMenuId(idMenu);
        Sale sale = saleService.getSaleById(idSale);
        SaleMenuKey saleMenuKey = new SaleMenuKey(sale, menu);
        if (sale != null || menu != null){
            saleMenuKey.setMenu(menu);
            saleMenuKey.setSale(sale);
        return saleMenuRepository.findById(saleMenuKey).orElse(null);
        }else {
            throw new RuntimeException("Venta o menu no encontrado");
        }
    }

    public SaleMenu saveSaleMenu(SaleMenu saleMenu){

        Menu menu = menuRepository.findById(saleMenu.getIdMenu()).get();
        saleMenu.setMenu(menu);
        Sale sale = saleRepository.findById(saleMenu.getIdSale()).get();
        saleMenu.setSale(sale);

        return saleMenuRepository.save(saleMenu);
    }

    public SaleMenu updateSalesMenu(SaleMenu saleMenu){
        SaleMenuKey keySaleMenu = new SaleMenuKey(saleMenu.getSale(), saleMenu.getMenu());
        SaleMenu newSaleMenu = findSaleMenuById(keySaleMenu.getMenu().getIdMenu(), keySaleMenu.getSale().getId());
        if (newSaleMenu == null){
            newSaleMenu.setQuantity(saleMenu.getQuantity());
            return newSaleMenu;
        }else {
            throw new RuntimeException("El registro no existe");
        }
    }
    public void deleteSaleMenu(long idSale, long idMenu){
        SaleMenuKey saleMenuKey = new SaleMenuKey();
        Menu menu = new Menu();
        menu.setIdMenu(idMenu);
        Sale sale = new Sale();
        sale.setId(idSale);
        saleMenuKey.setMenu(menu);
        saleMenuKey.setSale(sale);
        saleMenuRepository.deleteById(saleMenuKey);
    }

}
