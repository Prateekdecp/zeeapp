package com.zee.zee5app.dto;

import java.lang.*;
import javax.naming.NameNotFoundException;

import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Objects;
//@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Series implements Comparable<Series> {
	
	@Setter(value = AccessLevel.NONE)
	private String seriesName;
	
	private long length;
	
	@Setter(value = AccessLevel.NONE)
	private String id;
	
	private String category;
	private String releaseDate;
	private String trailer;
	private String cast[];
	private String langauage;
	
	public Series(String id, String seriesName, long length,  String language,String category, String releaseDate, String trailer,
			String[] cast) throws InvalidIdLengthException, NameNotFoundException {
		super();
		this.setId(id);
		this.setSeriesName(seriesName);
		this.setCast(cast);
		this.setCategory(category);
		this.setLangauage(language);
		this.setLength(length);
		this.setReleaseDate(releaseDate);
		this.setTrailer(trailer);
	}
	
	public Series() {
		
	}


	@Override
	public int compareTo(Series o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

	public void setSeriesName(String seriesName) throws NameNotFoundException {

		if(seriesName == null)
			throw new NameNotFoundException("series name not found");
		this.seriesName = seriesName;
	}

	public void setId(String id) throws InvalidIdLengthException {
		if(id.length()<6)
			throw new InvalidIdLengthException("id length less than 6");
		this.id = id;
	}
	
}