package com.dang.workout.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AttemptedWorkoutId implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name="workout_id")
	private int workoutId;
	@Column(name="user_id")
	private int userId;
	
	public AttemptedWorkoutId() {}
	public AttemptedWorkoutId(int workoutId, int userId) {
		this.workoutId = workoutId;
		this.userId = userId;
	}
	
	public int getWorkoutId() {
		return workoutId;
	}
	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "AttemptedWorkout [workoutId=" + workoutId + ", userId=" + userId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
		result = prime * result + workoutId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttemptedWorkoutId other = (AttemptedWorkoutId) obj;
		if (userId != other.userId)
			return false;
		if (workoutId != other.workoutId)
			return false;
		return true;
	}
	
	
	

}
