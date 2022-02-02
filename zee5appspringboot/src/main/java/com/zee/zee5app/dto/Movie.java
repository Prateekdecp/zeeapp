package com.zee.zee5app.dto;

import java.sql.Date;
import java.lang.*;
import java.util.Objects;
import javax.naming.NameNotFoundException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "movieName")},name="movie")
public class Movie implements Comparable<Movie>{

	@NotBlank
	private String movieName;
	
	
	private long length;
	
	@Id
	@Column(name="movieid")
	private String id;
	@NotBlank
	private String category;
	
	@NotBlank
	private String releaseDate;
	
	@NotBlank
	private String trailer;
	@NotBlank
	private String Cast;

	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

	
}
