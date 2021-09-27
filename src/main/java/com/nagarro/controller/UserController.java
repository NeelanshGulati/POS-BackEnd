package com.nagarro.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.nagarro.model.User;
import com.nagarro.service.UserService;

@CrossOrigin("*")
@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
@Produces(MediaType.APPLICATION_JSON)
@Path("/")
public class UserController {
	private UserService userService = new UserService();

	@GET
	@Path("/users")
	public List<User> getUsers() {
		List<User> user = userService.getAllUsers();
		return user;
	}

	@POST
	@Path("/users/login")
	public boolean canAuthenticate(@RequestBody User user) {
		User isvalid = userService.authenticateUser(user.getUsername(), user.getPassword());
		if (isvalid != null) {
			return true;
		}

		return false;
	}

}
