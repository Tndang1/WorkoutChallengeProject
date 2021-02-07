package com.dang.workout.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dang.workout.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}
