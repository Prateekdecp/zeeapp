package com.zee.zee5app.service.impl;

import java.util.Optional;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.repository.MovieRepo2;
import com.zee.zee5app.repository.impl.MovieRepositoryImpl;
import com.zee.zee5app.service.movieService2;

import exception.MovieIdNotFoundException;

public class movieServiceImpl implements movieService2 {
	
	private movieServiceImpl(){
		
	}
	private static movieService2 movieservice;
	public static movieService2 getInstance()
	{
		if(movieservice==null)
			movieservice=new movieServiceImpl();
		return movieservice;
	}
	MovieRepo2 movierepository=MovieRepositoryImpl.getInstance();
	@Override
	public String addMovie(Movies movie) {
		// TODO Auto-generated method stub
		return movierepository.addMovie(movie);
	}

	@Override
	public String updateMovie(String id, Movies movie) {
		// TODO Auto-generated method stub
		return movierepository.modifyMovie(id, movie);
	}

	@Override
	public Optional<Movies> getMovieById(String id) throws MovieIdNotFoundException {
		// TODO Auto-generated method stub
		return movierepository.getMovieById(id);
	}

	@Override
	public Movies[] getAllMovies() {
		// TODO Auto-generated method stub
		return movierepository.getMovies();
	}

	@Override
	public String deleteMovieById(String id) throws MovieIdNotFoundException {
		// TODO Auto-generated method stub
		return movierepository.deleteMovieById(id);
	}

}
