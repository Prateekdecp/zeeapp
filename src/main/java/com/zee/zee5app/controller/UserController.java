package com.zee.zee5app.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.payload.request.LoginRequest;
import com.zee.zee5app.payload.request.SignupRequest;
import com.zee.zee5app.payload.response.JwtResponse;
import com.zee.zee5app.payload.response.MessageResponse;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.security.jwt.JwtUtils;
import com.zee.zee5app.security.services.UserDetailsImpl;
import com.zee.zee5app.service.UserService;

//
//all insert movies/episodes====> admin
//all retrieval movies/episodes/subscription details===> user


@RestController
@RequestMapping("/api/auth")
public class UserController {

	// @requestbody is used to format json to java object

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateToken(authentication);
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();

		List<String> roles = userDetailsImpl.getAuthorities().stream().map(i -> i.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, userDetailsImpl.getId(), 
				userDetailsImpl.getUsername(), userDetailsImpl.getEmail(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
		if (userRepository.existsByUsername(signupRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username already exists"));
		}
		if (userRepository.existsByEmail(signupRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email already exists"));
		}
		User user = new User(signupRequest.getUsername(), signupRequest.getEmail(),
				passwordEncoder.encode(signupRequest.getPassword()), signupRequest.getFirstName(),
				signupRequest.getLastName());
		Set<String> strRoles = signupRequest.getRole();
		Set<Role> roles = new HashSet<Role>();
		if (strRoles == null) {
			Role userRole = roleRepository.findByRoleName(EROLE.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role not found"));
			roles.add(userRole);
		} else {
			strRoles.forEach(e -> {
				switch (e) {
				case "admin":
					Role roleAdmin = roleRepository.findByRoleName(EROLE.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role not found"));
					roles.add(roleAdmin);
					break;
				case "mod":
					Role roleModerator = roleRepository.findByRoleName(EROLE.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role not found"));
					roles.add(roleModerator);
					break;
				default:
					Role roleUser = roleRepository.findByRoleName(EROLE.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role not found"));
					roles.add(roleUser);
				}
			});
		}
		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.status(201).body(new MessageResponse("user created successfully"));
	}

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
