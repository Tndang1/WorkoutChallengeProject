package com.dang.workout.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dang.workout.entities.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Integer>{
	
}
