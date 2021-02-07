
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
	private AttemptedWorkoutId awoId;
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
		awoId = new AttemptedWorkoutId(1, 1);
		awo = em.find(AttemptedWorkout.class, awoId);
	}

	@AfterEach
	void tearDown() throws Exception {
		awoId = null;
		awo = null;
		em.close();
	}

	@Test
	void test_attemptedWorkout_db_connection() {
		assertNotNull(awo);
		assertEquals(true, awo.isCompleted());
	}

}
