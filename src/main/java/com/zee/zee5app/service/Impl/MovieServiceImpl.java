package com.zee.zee5app.service.Impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repository;
	
	
	
    private MovieServiceImpl()throws IOException {
		
	}

	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		Movie movie1=this.repository.save(movie);
		return movie1!=null?"successfully added movie":"failed to add movie";
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Movie> optional=getMovieById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else
			{
				this.repository.deleteById(id);
				return "success";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.findById(id);
	}

	@Override
	public Optional<List<Movie>> getAllMovie() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(this.repository.findAll());
	}

    
}