package com.shop.ShopService.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.shop.ShopService.service.CustomerService;
import com.shop.ShopService.dto.CustomerDTO;
import com.shop.ShopService.utility.DtoMapper;
import com.shop.ShopService.model.Customer;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getAll() {
        return customerService.findAll().stream()
                .map(DtoMapper::mapCustomerToDto)
                .toList();
    }

    @GetMapping("/{id}")

    public CustomerDTO getById(@PathVariable Long id) {
        Customer customer = customerService.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        return DtoMapper.mapCustomerToDto(customer);
    }

    @PostMapping
    public CustomerDTO create(@RequestBody Customer customer) {
        return DtoMapper.mapCustomerToDto(customerService.save(customer));
    }

    @PutMapping("/{id}")

    public CustomerDTO update(@PathVariable Long id, @RequestBody Customer updated) {
        return DtoMapper.mapCustomerToDto(customerService.update(id, updated));
    }

    @DeleteMapping("/{id}")

    public void delete(@PathVariable Long id) {
        customerService.deleteById(id);
    }
}
