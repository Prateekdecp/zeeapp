package com.zee.zee5app.service;

import java.util.Optional;

import com.zee.zee5app.dto.Movies;

import exception.MovieIdNotFoundException;

public interface movieService2 {
	public String addMovie(Movies movie);
	public String updateMovie(String id, Movies movie);
	public Optional<Movies> getMovieById(String id) throws MovieIdNotFoundException;
	public Movies[] getAllMovies();
	public String deleteMovieById(String id) throws MovieIdNotFoundException;
}
