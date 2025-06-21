package com.shop.ShopService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ShopService.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
