package com.shop.ShopService.utility;

import com.shop.ShopService.dto.*;
import com.shop.ShopService.model.*;

import java.util.stream.Collectors;

public class DtoMapper {

    public static ProductDTO mapProductToDto(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setImageUrl(product.getImageUrl());
        dto.setCategoryName(product.getCategory().getName());
        return dto;
    }

    public static CategoryDTO mapCategoryToDto(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        return dto;
    }

    public static CustomerDTO mapCustomerToDto(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setPhone(customer.getPhone());
        dto.setAddress(customer.getAddress());
        return dto;
    }

    public static OrderItemDTO mapOrderItemToDto(OrderItem item) {
        OrderItemDTO dto = new OrderItemDTO();
        dto.setProductId(item.getProduct().getId());
        dto.setProductName(item.getProduct().getName());
        dto.setQuantity(item.getQuantity());
        dto.setPrice(item.getPrice());
        return dto;
    }

    public static OrderDTO mapOrderToDto(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setCustomerId(order.getCustomer().getId());
        dto.setOrderDate(order.getOrderDate());
        dto.setItems(order.getItems().stream()
            .map(DtoMapper::mapOrderItemToDto)
            .collect(Collectors.toList()));
        dto.setTotalAmount(order.getTotalAmount());
        dto.setStatus(order.getStatus().name());
        return dto;
    }

    public static UserDTO mapUserToDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole());
        return dto;
    }

    public static ReviewDTO mapReviewToDto(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setCustomerName(review.getCustomer().getName());
        dto.setProductId(review.getProduct().getId());
        dto.setComment(review.getComment());
        dto.setRating(review.getRating());
        dto.setReviewDate(review.getReviewDate());
        return dto;
    }
}
