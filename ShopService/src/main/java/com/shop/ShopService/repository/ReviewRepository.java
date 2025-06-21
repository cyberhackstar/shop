package com.shop.ShopService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ShopService.model.Review;


public interface ReviewRepository extends JpaRepository<Review, Long> {
}
