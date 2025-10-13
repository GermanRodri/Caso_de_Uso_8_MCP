package com.uptc.frw.restaurant.service;


import com.uptc.frw.restaurant.model.DishMenu;
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

    public List<SaleMenu> findAllSaleMenuService(){
        return saleMenuRepository.findAll();
    }

    public SaleMenu findSaleMenuById(SaleMenuKey saleMenuKey) {
        return saleMenuRepository.findById(saleMenuKey).orElse(null);
    }

    public SaleMenu saveSaleMenu(SaleMenu saleMenu){
        Menu menu = menuRepository.findById(saleMenu.getIdSale()).get();
        saleMenu.setMenu(menu);
        Sale sale = saleRepository.findById(saleMenu.getIdSale()).get();
        saleMenu.setSale(sale);
        return saleMenuRepository.save(saleMenu);
    }

    public SaleMenu updateSalesMenu(SaleMenu saleMenu){
        SaleMenuKey keySaleMenu = findSaleMenuById(saleMenu.getMenu(),saleMenu.getSale());
        SaleMenu newSaleMenu = findSaleMenuById(keySaleMenu);
        if (newSaleMenu == null){
            newSaleMenu.setQuantity(saleMenu.getQuantity());
            return newSaleMenu;
        }else {
            throw new RuntimeException("El registro no existe");
        }
    }
    public void deleteSaleMenu(SaleMenuKey saleMenuKey){
        saleMenuRepository.deleteById(saleMenuKey);
    }

}
