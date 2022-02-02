package com.zee.zee5app.dto;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import java.lang.*;
import java.math.BigDecimal;
import java.math.BigInteger;

//@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity     //(entity class for ORM Mapping)
@Table(name="register")


public class Register implements Comparable<Register>{

	@Id
	@Column(name="regid")
	private String id;
	
	@Size(max=50)
	@NotBlank
	private String firstName;
	
	@Size(max=50)
	@NotBlank
	private String lastName;
	
	@Size(max=50)
	@Email
	private String email;
	
	@Size(max=100)
	@NotBlank
	private String password;
	
	@NotNull
	private BigDecimal contactnumber;
	

	@Override
	public int compareTo(Register o) {
		 //TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
	
}
