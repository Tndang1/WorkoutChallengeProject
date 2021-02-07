package com.dang.workout.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WorkoutTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Workout workout;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("workoutPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		workout = em.find(Workout.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		workout = null;
		em.close();
	}

	@Test
	void workout_db_connection() {
		assertNotNull(workout);
		assertEquals("The Short Card / No Equipment", workout.getTitle());
		assertEquals(false, workout.isReqEquip());
	}
	@Test
	void workout_exercise_mapping() {
		List<Exercise> ex = workout.getExercise();
		assertNotNull(ex);
		assertTrue(ex.size() > 0);
	}
	@Test
	void workout_review_mapping() {
		List<Review> rv = workout.getReviews();
		assertNotNull(rv);
		assertTrue(rv.size()>0);
	}
	@Test
	void workout_user() {
		User user = workout.getUser();
		assertNotNull(user);
		assertEquals("user", user.getUsername());
	}
	@Test
	void workout_attempts() {
		List<AttemptedWorkout> a = workout.getAttempts();
		assertNotNull(a);
		assertTrue(a.size() > 0);
	}
}
