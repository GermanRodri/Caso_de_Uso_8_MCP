package com.uptc.frw.restaurant.repository;

import com.uptc.frw.restaurant.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish,Long> {
}
