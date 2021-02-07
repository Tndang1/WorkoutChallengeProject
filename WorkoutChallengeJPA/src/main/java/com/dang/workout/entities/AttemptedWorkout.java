package com.dang.workout.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="attempted_workout")
public class AttemptedWorkout {
	@EmbeddedId
	private AttemptedWorkoutId id;
	private boolean completed;
	public AttemptedWorkoutId getId() {
		return id;
	}
	public void setId(AttemptedWorkoutId id) {
		this.id = id;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (completed ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AttemptedWorkout other = (AttemptedWorkout) obj;
		if (completed != other.completed)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AttemptedWorkout [id=" + id + ", completed=" + completed + "]";
	}

}
