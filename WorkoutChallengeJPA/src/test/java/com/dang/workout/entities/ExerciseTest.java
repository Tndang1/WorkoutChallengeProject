package com.dang.workout.entities;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExerciseTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Exercise ex;

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
		ex = em.find(Exercise.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		ex = null;
		em.close();
	}

	@Test
	void test_exercise_db_connection() {
		assertNotNull(ex);
		assertEquals(1, ex.getId());
		assertEquals("Push-ups", ex.getName());
	}

}
