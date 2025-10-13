package com.uptc.frw.restaurant.repository;

import com.uptc.frw.restaurant.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Long> {
}
