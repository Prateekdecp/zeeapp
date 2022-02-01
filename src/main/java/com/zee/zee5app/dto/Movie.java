package com.zee.zee5app.dto;

import java.net.URL;
import java.lang.*;
import java.util.Objects;
import javax.naming.NameNotFoundException;

import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString

public class Movie implements Comparable<Movie>{
	
	
	public Movie(String id, String movieName, long length, String category, String releaseDate, String trailer,
			String[] cast) throws InvalidIdLengthException, NameNotFoundException {
		super();
		this.setId(id);
		this.setMovieName(movieName);
		this.setCast(cast);
		this.setCategory(category);
		this.setLength(length);
		this.setReleaseDate(releaseDate);
		this.setTrailer(trailer);
	}
	
	public Movie() {
		
	}


	@Setter(value = AccessLevel.NONE)
	private String movieName;
	
	private long length;
	
	@Setter(value = AccessLevel.NONE)
	private String id;
	
	private String category;
	
	private String releaseDate;
	private String trailer;
	private String Cast[];
	
	


	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

	public void setId(String id) throws InvalidIdLengthException {
		if(id.length()<6) {
			throw new InvalidIdLengthException("id length less than 6");
		}
		this.id = id;

	}

	public void setMovieName(String movieName) throws NameNotFoundException {
		if(movieName == null) {
			throw new NameNotFoundException("movie name not found");
		}
		this.movieName = movieName;
	}
	
}
