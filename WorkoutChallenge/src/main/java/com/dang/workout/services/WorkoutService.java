package com.dang.workout.services;

import java.util.List;

import com.dang.workout.entities.Exercise;
import com.dang.workout.entities.Workout;

public interface WorkoutService {
	Workout getWorkoutById(int workoutId);
	List<Workout> allWorkouts();
	Workout createWorkout(Workout workout);
	Workout updateWorkout(Workout workout, int workoutId);
	boolean removeWorkout(int workoutId);
	List<Exercise> workoutExercise(int workoutId);
	Exercise getExerciseById(int exerId);
	Exercise addExercise(Exercise exercise);
	Exercise updateExercise(Exercise exercise, int exerId);
	boolean removeExercise(int exerId);
}
