package com.shop.ShopService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ShopService.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
