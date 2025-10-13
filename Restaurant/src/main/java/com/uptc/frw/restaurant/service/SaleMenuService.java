package com.uptc.frw.restaurant.service;


import com.uptc.frw.restaurant.model.SaleMenu;
import com.uptc.frw.restaurant.repository.SaleMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleMenuService {
    @Autowired
    private SaleService saleService;
    @Autowired
    private SaleMenuRepository saleMenuRepository;

    public List<SaleMenu> findAllSaleMenuService(){
        return saleMenuRepository.findAll();
    }

    public SaleMenu getSaleMenuById(long id) {
        SaleMenu saleMenu = saleMenuRepository.findById(id).orElse(null);
        return saleMenu;
    }

    public SaleMenu saveSaleMenu(SaleMenu saleMenu){
        SaleMenu newSaleMenu = saleMenuRepository.save(saleMenu);
        return newSaleMenu;
    }

    public SaleMenu updateSalesMenu(SaleMenu saleMenu){
        SaleMenu newSaleMenu = getSaleMenuById(saleMenu.getIdMenu());
        if (newSaleMenu == null){
            newSaleMenu.setQuantity(saleMenu.getQuantity());
            return newSaleMenu;
        }else {
            throw new RuntimeException("El registro no existe");
        }
    }


}
