package com.dang.workout.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dang.workout.entities.User;
import com.dang.workout.services.AuthService;
import com.dang.workout.services.UserService;

@RequestMapping("api/user")
@CrossOrigin({"*", "http://localhost:4210"})
@RestController
public class UserController {
	@Autowired
	private UserService userServ;
	@Autowired
	private AuthService authServ;
	
	@PutMapping("/update")
	public User updateUser(HttpServletResponse res,
			HttpServletRequest req,
			Principal principal,
			@RequestBody User user,
			@PathVariable Integer id) {
		User updated = null;
		try {			
			updated = authServ.updateUser(user, id);
			if(updated == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			res.setStatus(400);
		}
		return updated;
	}
}
