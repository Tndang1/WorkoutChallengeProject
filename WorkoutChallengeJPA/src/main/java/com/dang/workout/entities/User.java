package com.dang.workout.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String role;
	private boolean enabled;
	@OneToMany(mappedBy="user")
	private List<Workout> submittedWorkouts;
	@OneToMany(mappedBy="user")
	private List<Review> userReviews;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinTable(name="saved_workout",
	joinColumns = @JoinColumn (name="user_id"),
	inverseJoinColumns = @JoinColumn(name="workout_id"))
	private List<Workout> savedWorkouts;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinTable(name="attempted_workout",
	joinColumns = @JoinColumn (name="user_id"),
	inverseJoinColumns = @JoinColumn(name="workout_id"))
	private List<Workout> attemptedWorkouts;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<Workout> getSubmittedWorkouts() {
		return submittedWorkouts;
	}
	public void setSubmittedWorkouts(List<Workout> submittedWorkouts) {
		this.submittedWorkouts = submittedWorkouts;
	}
	public List<Review> getUserReviews() {
		return userReviews;
	}
	public void setUserReviews(List<Review> userReviews) {
		this.userReviews = userReviews;
	}
	public List<Workout> getSavedWorkouts() {
		return savedWorkouts;
	}
	public void setSavedWorkouts(List<Workout> savedWorkouts) {
		this.savedWorkouts = savedWorkouts;
	}
	public List<Workout> getAttemptedWorkouts() {
		return attemptedWorkouts;
	}
	public void setAttemptedWorkouts(List<Workout> attemptedWorkouts) {
		this.attemptedWorkouts = attemptedWorkouts;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", enabled="
				+ enabled + "]";
	}
	
	
	
}
