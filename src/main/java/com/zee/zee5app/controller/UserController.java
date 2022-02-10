package com.zee.zee5app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.payload.response.MessageResponse;
import com.zee.zee5app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	// @requestbody is used to format json to java object

	@Autowired
	UserService userService;

	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@Valid @RequestBody User register) throws AlreadyExistsException {
		User result = userService.addUser(register);
		return ResponseEntity.status(201).body(result);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Long id) throws IdNotFoundException {
		User register = userService.getUserById(id);
		return ResponseEntity.ok(register);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllUsers() {
		Optional<List<User>> optional = userService.getAllUserDetails();
		if (optional.isEmpty()) {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageResponse("no records found"));
		}
		return ResponseEntity.ok(optional);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMovieById(@PathVariable("id") Long id) throws IdNotFoundException {
		String result = userService.deleteUserById(id);
		if (result.equals("user deleted successfully")) {
			ResponseEntity.status(200).body(new MessageResponse("record deleted successfully"));
		}
		return ResponseEntity.ok(new MessageResponse("failed to delete"));
	}
}
