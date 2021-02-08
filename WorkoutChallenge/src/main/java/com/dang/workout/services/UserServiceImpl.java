package com.dang.workout.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dang.workout.entities.Review;
import com.dang.workout.entities.User;
import com.dang.workout.entities.Workout;
import com.dang.workout.entities.AttemptedWorkout;
import com.dang.workout.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;

	@Override
	public User findById(int id) {
		Optional<User> userOpt = userRepo.findById(id);
		if(userOpt.isPresent()) {
			return userOpt.get();
		}
		return null;
	}

	@Override
	public List<Workout> findUserSubmissions(int id) {
		User u = this.findById(id);
		return u.getSubmittedWorkouts();
	}

	@Override
	public List<Workout> findUserSavedWorkout(int id) {
		User u = this.findById(id);
		return u.getSavedWorkouts();
	}

	@Override
	public List<AttemptedWorkout> findUserAttempts(int id) {
		User u = this.findById(id);
		return u.getAttemptedWorkouts();
	}

	@Override
	public List<Review> findUserReviews(int id) {
		User u = this.findById(id);		
		return u.getUserReviews();
	}

}
