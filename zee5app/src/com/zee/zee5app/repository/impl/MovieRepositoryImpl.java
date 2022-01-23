package com.zee.zee5app.repository.impl;



import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.MovieRepo2;

import exception.MovieIdNotFoundException;

public class MovieRepositoryImpl implements MovieRepo2 {
	private HashSet<Movies> movies=new LinkedHashSet<>();
	
	private static MovieRepo2 repository;
	
	public static MovieRepo2 getInstance()
	{
		if(repository==null)
			repository=new MovieRepositoryImpl();
		return repository;
	}
	@Override
	public Movies[] getMovies() {
		// TODO Auto-generated method stub
		Movies [] result=new Movies[movies.size()];
		return movies.toArray(result);
	}

	@Override
	public String addMovie(Movies movie) {
		// TODO Auto-generated method stub
		boolean res=movies.add(movie);
		return res? "success":"failure";
	}


	@Override
	public String modifyMovie(String movieId, Movies movie) {
		// TODO Auto-generated method stub
		for(Movies movie1:movies)
		{
			if(movie1!=null && movie1.getMovieId().equals(movieId))
			{
				movie1=movie;
				return "success";
			}
		}
		return "id does not exist";
	}
	@Override
	public String deleteMovieById(String id) throws MovieIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movies> optional=getMovieById(id);
		if(optional.isPresent())
		{
			boolean res=movies.remove(optional.get());
			if(res)
				return "success";
			return "fail";
		}
		throw new MovieIdNotFoundException("movie id not found");
	}
	@Override
	public Optional<Movies> getMovieById(String movieId) throws MovieIdNotFoundException {
		// TODO Auto-generated method stub
		Movies movies2=null;
		for (Movies movies : movies) {
			if(movies.getMovieId().equals(movieId))
			{
				movies2=movies;
				break;
			}
		}
		return Optional.of(Optional.ofNullable(movies2)).orElseThrow(()->new MovieIdNotFoundException("movieId not found"));
	}

}
