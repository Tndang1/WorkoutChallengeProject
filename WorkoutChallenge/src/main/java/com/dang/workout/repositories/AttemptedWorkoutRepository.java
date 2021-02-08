package com.dang.workout.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dang.workout.entities.AttemptedWorkout;

public interface AttemptedWorkoutRepository extends JpaRepository<AttemptedWorkout, Integer>{
	
}
