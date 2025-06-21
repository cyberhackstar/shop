package com.shop.ShopService.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.shop.ShopService.service.ReviewService;
import com.shop.ShopService.dto.ReviewDTO;
import com.shop.ShopService.utility.DtoMapper;
import com.shop.ShopService.model.Review;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<ReviewDTO> getAll() {
        return reviewService.findAll().stream()
            .map(DtoMapper::mapReviewToDto)
            .toList();
    }

    @GetMapping("/{id}")
    public ReviewDTO getById(@PathVariable Long id) {
        return reviewService.findById(id)
            .map(DtoMapper::mapReviewToDto)
            .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));
    }

    @PostMapping
    public ReviewDTO create(@RequestBody Review review) {
        return DtoMapper.mapReviewToDto(reviewService.save(review));
    }

    @PutMapping("/{id}")
    public ReviewDTO update(@PathVariable Long id, @RequestBody Review updated) {
        return DtoMapper.mapReviewToDto(reviewService.update(id, updated));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.deleteById(id);
    }
}
