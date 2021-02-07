package com.dang.workout.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Workout {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String category;
	@Column(name="requires_equipment")
	private boolean reqEquip;
	@Column(name="estimated_time")
	private String estimatedTime;
	private double rating;
	@OneToMany(mappedBy="workout")
	private List<Exercise> exercise;
	@OneToMany(mappedBy="workout")
	private List<Review> reviews;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isReqEquip() {
		return reqEquip;
	}
	public void setReqEquip(boolean reqEquip) {
		this.reqEquip = reqEquip;
	}
	public String getEstimatedTime() {
		return estimatedTime;
	}
	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public List<Exercise> getExercise() {
		return exercise;
	}
	public void setExercise(List<Exercise> exercise) {
		this.exercise = exercise;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
		Workout other = (Workout) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Workout [id=" + id + ", title=" + title + ", category=" + category + ", reqEquip=" + reqEquip
				+ ", estimatedTime=" + estimatedTime + ", rating=" + rating + "]";
	}
	
}
