/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxttrendz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.example.nxttrendz1.service.*;
import com.example.nxttrendz1.model.*;

@RestController
public class ReviewController {
    @Autowired
    private ReviewJpaService service;

    @GetMapping("/reviews")
    public ArrayList<Review> getReviews() {
        return service.getReviews();
    }

    @GetMapping("/reviews/{reviewId}")
    public Review getReviewById(@PathVariable("productId") int reviewId) {
        return service.getReviewById(reviewId);
    }

    @PostMapping("/reviews")
    public Review addReview(@RequestBody Review review) {
        return service.addReview(review);
    }

    @PutMapping("/reviews/{reviewId}")
    public Review updateReview(@PathVariable("reviewId") int reviewId, @RequestBody Review review) {
        return service.updateReview(reviewId, review);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public void deleteReview(@PathVariable("reviewId") int reviewId) {
        service.deleteReview(reviewId);
    }

    @GetMapping("/products/reviews")
    public Product getReviewProduct(int reviewId) {
        return service.getReviewProduct(reviewId);
    }
}
