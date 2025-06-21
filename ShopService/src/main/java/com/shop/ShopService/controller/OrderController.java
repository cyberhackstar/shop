package com.shop.ShopService.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.shop.ShopService.service.OrderService;
import com.shop.ShopService.dto.OrderDTO;
import com.shop.ShopService.utility.DtoMapper;
import com.shop.ShopService.model.Order;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderDTO> getAll() {
        return orderService.findAll().stream()
            .map(DtoMapper::mapOrderToDto)
            .toList();
    }

    @GetMapping("/{id}")
    public OrderDTO getById(@PathVariable Long id) {
        Order order = orderService.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        return DtoMapper.mapOrderToDto(order);
    }

    @PostMapping
    public OrderDTO create(@RequestBody Order order) {
        return DtoMapper.mapOrderToDto(orderService.save(order));
    }

    @PutMapping("/{id}")
    public OrderDTO update(@PathVariable Long id, @RequestBody Order updated) {
        return DtoMapper.mapOrderToDto(orderService.update(id, updated));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderService.deleteById(id);
    }
}
