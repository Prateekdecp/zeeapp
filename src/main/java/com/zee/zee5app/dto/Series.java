package com.zee.zee5app.dto;

import java.lang.*;
import java.sql.Date;

import javax.naming.NameNotFoundException;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString

@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "seriesname")},name="series")
public class Series implements Comparable<Series> {
	
	@NotBlank
	private String seriesName;
	
	@Max(value=70)
	private int agelimit;
	
	@Id
	@Column(name="seriesid")
	private String seriesid;
	
	@NotBlank
	private String category;
	
	@NotNull
	private String releaseDate;
	
	@NotBlank
	private String trailer;
	@NotBlank
	private String cast;
	@NotBlank
	private String language;
	
	@Min(value=1)
	private int nofofepisodes;


	@Override
	public int compareTo(Series o) {
		// TODO Auto-generated method stub
		return this.seriesid.compareTo(o.getSeriesid());
	}

	@OneToMany(mappedBy = "series",cascade = CascadeType.ALL)
	private List<Episodes> episodes=new ArrayList<Episodes>();
	
}