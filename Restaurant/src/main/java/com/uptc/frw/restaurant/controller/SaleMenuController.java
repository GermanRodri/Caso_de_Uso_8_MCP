package com.uptc.frw.restaurant.controller;

import com.uptc.frw.restaurant.service.SaleService;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("SalesMenu")
public class SaleMenuController {

    @Autowired
    private SaleService saleService;
}
