package com.dang.workout.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dang.workout.entities.User;
import com.dang.workout.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User register(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setEnabled(true);
		user.setRole("user");
		return userRepo.saveAndFlush(user);
	}

	@Override
	public User updateUser(User user, int id) {
		Optional<User> userOpt = userRepo.findById(id);
		User dbUser = null;
		if(userOpt.isPresent()) {
			dbUser = userOpt.get();
		if(user.getUsername() != null) {
			dbUser.setUsername(user.getUsername());
		}
		if(user.getPassword() != null) {
			dbUser.setPassword(user.getPassword());
		}
		if(user.getRole() != null) {
			dbUser.setRole(user.getRole());
		}
		dbUser.setEnabled(user.isEnabled());
		}
		return userRepo.saveAndFlush(dbUser);
	}
	
	@Override
	public User findUserByName(String name) {
		Optional<User> userOpt = userRepo.findByUsername(name);
		User dbUser = null;
		if(userOpt.isPresent()) {
			dbUser = userOpt.get();
		}
		return dbUser;
	}

}