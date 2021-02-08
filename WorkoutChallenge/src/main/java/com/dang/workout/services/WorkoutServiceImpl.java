package com.dang.workout.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dang.workout.entities.Exercise;
import com.dang.workout.entities.Workout;
import com.dang.workout.repositories.ExerciseRepository;
import com.dang.workout.repositories.WorkoutRepository;

@Service
public class WorkoutServiceImpl implements WorkoutService {
	@Autowired
	private WorkoutRepository woRepo;
	@Autowired
	private ExerciseRepository exRepo;
	
	@Override
	public Workout getWorkoutById(int workoutId) {
		Optional<Workout> woOpt = woRepo.findById(workoutId);
		Workout wo = null;
		if(woOpt.isPresent()) {
			wo = woOpt.get();
		}
		return wo;
	}
	@Override
	public List<Workout> allWorkouts() {
		return woRepo.findAll();
	}
	@Override
	public Workout createWorkout(Workout workout) {
		return woRepo.saveAndFlush(workout);
	}
	@Override
	public Workout updateWorkout(Workout workout, int workoutId) {
		Workout dbWo = this.getWorkoutById(workoutId);
		if (workout.getCategory() != null) dbWo.setCategory(workout.getCategory());
		if(workout.getEstimatedTime() != null) dbWo.setEstimatedTime(workout.getEstimatedTime());
		if(workout.getTitle() != null) dbWo.setTitle(workout.getTitle());
		return woRepo.saveAndFlush(dbWo);
	}
	@Override
	public boolean removeWorkout(int workoutId) {
		Workout dbWo = this.getWorkoutById(workoutId);
		if(dbWo != null) {
		List<Exercise> dbWoEx = dbWo.getExercise();
		if(!dbWoEx.isEmpty()) {
			for(Exercise ex: dbWoEx) {
				this.removeExercise(ex.getId());
			}
		}
		woRepo.delete(dbWo);
		}
		Optional<Workout> woOpt = woRepo.findById(workoutId);
		return !woOpt.isPresent();
	}
	@Override
	public List<Exercise> workoutExercise(int workoutId) {
		Workout wo = this.getWorkoutById(workoutId);
		return wo.getExercise();
	}
	@Override
	public Exercise getExerciseById(int exerId) {
		Optional<Exercise> exOpt = exRepo.findById(exerId);
		Exercise ex = null;
		if (exOpt.isPresent()) {
			ex = exOpt.get();
		}
		return ex;
	}
	@Override
	public Exercise addExercise(Exercise exercise) {
		return exRepo.saveAndFlush(exercise);
	}
	@Override
	public Exercise updateExercise(Exercise exercise, int exerId) {
		Exercise dbEx = this.getExerciseById(exerId);
		if(exercise.getDuration() != null) dbEx.setDuration(exercise.getDuration());
		if(exercise.getEquipment() != null) dbEx.setEquipment(exercise.getEquipment());
		if(exercise.getName() != null) dbEx.setName(exercise.getName());
		if(exercise.getRepetitions() != null) dbEx.setRepetitions(exercise.getRepetitions());
		if(exercise.getWeight() != null) dbEx.setWeight(exercise.getWeight());
		return exRepo.saveAndFlush(dbEx);
	}
	@Override
	public boolean removeExercise(int exerId) {
		Exercise dbEx = this.getExerciseById(exerId);
		if(dbEx != null) {
			exRepo.delete(dbEx);
		}
		Optional<Exercise> exOpt = exRepo.findById(exerId);
		return !exOpt.isPresent();
	}
}
