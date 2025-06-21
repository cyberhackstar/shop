package com.shop.ShopService.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.shop.ShopService.service.OrderItemService;
import com.shop.ShopService.dto.OrderItemDTO;
import com.shop.ShopService.utility.DtoMapper;
import com.shop.ShopService.model.OrderItem;

@RestController
@RequestMapping("/api/orderitems")
public class OrderItemController {

    @Autowired
    private OrderItemService orderitemService;

    @GetMapping
    public List<OrderItemDTO> getAll() {
        return orderitemService.findAll().stream()
            .map(DtoMapper::mapOrderItemToDto)
            .toList();
    }

    @GetMapping("/{id}")
    public OrderItemDTO getById(@PathVariable Long id) {
        return orderitemService.findById(id)
            .map(DtoMapper::mapOrderItemToDto)
            .orElseThrow(() -> new RuntimeException("OrderItem not found with id: " + id));
    }

    @PostMapping
    public OrderItemDTO create(@RequestBody OrderItem orderitem) {
        return DtoMapper.mapOrderItemToDto(orderitemService.save(orderitem));
    }

    @PutMapping("/{id}")
    public OrderItemDTO update(@PathVariable Long id, @RequestBody OrderItem updated) {
        return DtoMapper.mapOrderItemToDto(orderitemService.update(id, updated));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderitemService.deleteById(id);
    }
}
