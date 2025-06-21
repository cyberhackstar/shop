package com.shop.ShopService.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ShopService.model.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {
}
