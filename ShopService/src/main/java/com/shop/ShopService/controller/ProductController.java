package com.shop.ShopService.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.shop.ShopService.service.ProductService;
import com.shop.ShopService.dto.ProductDTO;
import com.shop.ShopService.utility.DtoMapper;
import com.shop.ShopService.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> getAll() {
        return productService.findAll().stream()
            .map(DtoMapper::mapProductToDto)
            .toList();
    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Long id) {
        return productService.findById(id)
            .map(DtoMapper::mapProductToDto)
            .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @PostMapping
    public ProductDTO create(@RequestBody Product product) {
        return DtoMapper.mapProductToDto(productService.save(product));
    }

    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable Long id, @RequestBody Product updated) {
        return DtoMapper.mapProductToDto(productService.update(id, updated));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
