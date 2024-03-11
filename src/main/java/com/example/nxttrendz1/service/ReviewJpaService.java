/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here

package com.example.nxttrendz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import com.example.nxttrendz1.repository.*;
import com.example.nxttrendz1.model.*;

@Service
public class ReviewJpaService implements ReviewRepository {

    @Autowired
    private ReviewJpaRepository repository;

    @Override
    public ArrayList<Review> getReviews() {
        List<Review> list = repository.findAll();
        ArrayList<Review> reviews = new ArrayList<>(list);
        return reviews;
    }

    @Override
    public Review getReviewById(int reviewId) {
        try {
            Review reviews = repository.findById(reviewId).get();
            return reviews;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Review addReview(Review review) {
        repository.save(review);
        return review;
    }

    @Override
    public Review updateReview(int reviewId, Review review) {
        try {
            Review reviews = repository.findById(reviewId).get();

            if (review.getReviewContent() != null) {
                reviews.setReviewContent(review.getReviewContent());
            }
            if (review.getRating() != 0) {
                reviews.setRating(review.getRating());
            }

            repository.save(reviews);
            return reviews;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteReview(int reviewId) {
        try {
            repository.deleteById(reviewId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Product getReviewProduct(int reviewId) {
        try {
            Review review = repository.findById(reviewId).get();
            return review.getProduct();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
