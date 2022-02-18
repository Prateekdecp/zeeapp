package com.zee.zee5app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.payload.response.MessageResponse;
import com.zee.zee5app.service.MovieService;

@CrossOrigin("*")
@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	MovieService movieService;

	@PostMapping("/addMovie")
	public ResponseEntity<?> addMovie(@Valid @RequestBody Movie movie) {
		Movie result = movieService.addMovie(movie);
		return ResponseEntity.status(201).body(result);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") String id) throws IdNotFoundException {
		Movie movie = movieService.getMovieById(id);
		return ResponseEntity.ok(movie);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllUsers() {
		Optional<List<Movie>> optional = movieService.getAllMovie();
		if (optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageResponse("no records found"));
		}
		return ResponseEntity.ok(optional);
	}
}
