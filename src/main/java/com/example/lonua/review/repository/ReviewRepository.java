package com.example.lonua.review.repository;

import com.example.lonua.review.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    Optional<Review> findByReviewIdx(Integer reviewIdx);
}
