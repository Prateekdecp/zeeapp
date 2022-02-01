package com.zee.zee5app.service.Impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.Impl.MovieRepositoryImpl;

@Service
public class MovieServiceImpl implements MovieService {

	private MovieRepository repository = null;
	private static MovieService service;	
	
	
	
    private MovieServiceImpl()throws IOException {
		
	}

	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return this.repository.addMovie(movie);
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.deleteMovie(id);
	}

	@Override
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.modifyMovie(id, movie);
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.getMovieById(id);
	}

	@Override
	public Optional<List<Movie>> getAllMovie() {
		// TODO Auto-generated method stub
		return this.repository.getAllMovie();
	}
    
    
}