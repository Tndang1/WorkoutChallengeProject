package com.dang.workout.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dang.workout.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
