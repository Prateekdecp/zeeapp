package com.zee.zee5app.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
@Table(name="episodes")
public class Episodes implements Comparable<Episodes>{

	@Id
	@Column(name="episodeid")
	private String episodeid;

	
	@NotNull
	private int length;
	
	@NotBlank
	private String episodename;
	@Override
	public int compareTo(Episodes o) {
		// TODO Auto-generated method stub
		return this.episodeid.compareTo(o.getEpisodeid());
	}

	@ManyToOne
	@JoinColumn(name="seriesid") // create foreign_key
	private Series series;
}
