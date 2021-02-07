
package com.dang.workout.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AttemptedWorkoutTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private AttemptedWorkout awo;

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
		awo = em.find(AttemptedWorkout.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		awo = null;
		em.close();
	}

	@Test
	void test_attemptedWorkout_db_connection() {
		assertNotNull(awo);
		assertEquals(true, awo.isCompleted());
	}
	@Test
	void test_attemptedWorkout_user() {
		User u = awo.getUser();
		assertNotNull(u);
		assertEquals(1, u.getId());
	}
	@Test
	void test_attemptedWorkout_workout() {
		Workout w = awo.getWorkout();
		assertNotNull(w);
		assertEquals(1, w.getId());
	}

}
