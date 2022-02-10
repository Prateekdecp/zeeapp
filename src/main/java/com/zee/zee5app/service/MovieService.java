package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.MovieRepository;

public interface MovieService {
	
	public Movie addMovie(Movie movie);
	public String deleteMovie(String id) throws IdNotFoundException;
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException;
	public Movie getMovieById(String id) throws IdNotFoundException;
	public Optional<List<Movie>> getAllMovie();
	
}
