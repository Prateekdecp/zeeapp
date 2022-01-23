package com.zee.zee5app.repository;

import java.util.Optional;

import com.zee.zee5app.dto.Movies;

import exception.MovieIdNotFoundException;
public interface MovieRepo2 {
	public Movies[] getMovies();
	public String addMovie(Movies movie);
	public Optional<Movies> getMovieById(String movieId) throws MovieIdNotFoundException;
	public String modifyMovie(String movieId,Movies movie);
	public String deleteMovieById(String id) throws MovieIdNotFoundException;
}
