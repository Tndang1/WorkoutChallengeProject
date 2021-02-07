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

class UserTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;

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
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		user = null;
		em.close();
	}

	@Test
	void test_user_db_connection() {
		assertNotNull(user);
		assertEquals(1, user.getId());
		assertEquals("user", user.getUsername());
		assertEquals("user", user.getRole());
	}
	@Test
	void test_user_submittedWorkouts() {
		List<Workout> sw = user.getSubmittedWorkouts();
		assertNotNull(sw);
		assertTrue(sw.size() > 0);
	}
	@Test
	void test_user_reviews() {
		List<Review> rv = user.getUserReviews();
		assertNotNull(rv);
		assertTrue(rv.size() > 0);
	}
	@Test
	void test_user_saved_workouts() {
		List<Workout> savWO = user.getSavedWorkouts();
		assertNotNull(savWO);
		assertTrue(savWO.size() > 0);
	}
	@Test
	void test_user_attempted_workouts() {
		List<Workout> aw = user.getAttemptedWorkouts();
		assertNotNull(aw);
		assertTrue(aw.size() > 0);
	}

}
