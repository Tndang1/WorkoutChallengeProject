package com.dang.workout.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dang.workout.entities.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

}
