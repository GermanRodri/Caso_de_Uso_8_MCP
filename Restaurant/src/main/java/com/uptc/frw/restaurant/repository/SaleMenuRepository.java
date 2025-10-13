package com.uptc.frw.restaurant.repository;

import com.uptc.frw.restaurant.model.SaleMenu;
import com.uptc.frw.restaurant.model.key.SaleMenuKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleMenuRepository extends JpaRepository<SaleMenu, SaleMenuKey> {
}
