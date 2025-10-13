package com.uptc.frw.restaurant.repository;

import com.uptc.frw.restaurant.model.DishMenu;
import com.uptc.frw.restaurant.model.key.DishMenuKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishMenuRepository extends JpaRepository<DishMenu, DishMenuKey> {

}
