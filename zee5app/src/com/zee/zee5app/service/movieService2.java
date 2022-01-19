package com.zee.zee5app.service;

import com.zee.zee5app.dto.Movies;

public interface movieService2 {
	public String addMovie(Movies movie);
	public String updateMovie(String id, Movies movie);
	public Movies getMovieById(String id);
	public Movies[] getAllMovies();
	public String deleteMovieById(String id);
}
