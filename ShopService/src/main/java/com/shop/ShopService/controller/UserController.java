package com.shop.ShopService.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.shop.ShopService.service.UserService;
import com.shop.ShopService.dto.UserDTO;
import com.shop.ShopService.utility.DtoMapper;
import com.shop.ShopService.model.User;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.findAll().stream()
            .map(DtoMapper::mapUserToDto)
            .toList();
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id) {
        return userService.findById(id)
            .map(DtoMapper::mapUserToDto)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @PostMapping
    public UserDTO create(@RequestBody User user) {
        return DtoMapper.mapUserToDto(userService.save(user));
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody User updated) {
        return DtoMapper.mapUserToDto(userService.update(id, updated));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
