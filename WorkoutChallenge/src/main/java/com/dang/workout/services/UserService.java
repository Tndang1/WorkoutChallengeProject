package com.dang.workout.services;

import java.util.List;

import com.dang.workout.entities.Review;
import com.dang.workout.entities.User;
import com.dang.workout.entities.Workout;
import com.dang.workout.entities.AttemptedWorkout;

public interface UserService {
	User findById(int id);
	List<Workout> findUserSubmissions(int id);
	List<Workout> findUserSavedWorkout(int id);
	List<AttemptedWorkout> findUserAttempts(int id);
	List<Review> findUserReviews(int id);
}
