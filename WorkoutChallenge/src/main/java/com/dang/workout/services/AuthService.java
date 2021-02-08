package com.dang.workout.services;

import com.dang.workout.entities.User;

public interface AuthService {
	User register(User user);
	User updateUser(User user, int id);
	User findUserByName(String name);
}
