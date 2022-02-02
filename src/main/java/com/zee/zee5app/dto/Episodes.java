package com.zee.zee5app.dto;




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

public class Episodes implements Comparable<Episodes>{

	private String id;

	private String movieid;

	private int length;

	private int seriesname;
	@Override
	public int compareTo(Episodes o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

}
