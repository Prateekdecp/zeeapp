package com.zee.zee5app.dto;

import java.util.Objects;

import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
//@AllArgsConstructor
//@NoArgsConstructor

@EqualsAndHashCode
@ToString

public class Register implements Comparable<Register>{
//public class Register {
	//add contact number field
	public Register(String id, String firstName, String lastName, String email, String password, BigDecimal contactnumber) 
			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		super();
 		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setPassword(password);
		this.setContactnumber(contactnumber);	
		}
	
	public Register(String id, String firstName, String lastName, String email, String password) 
			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		super();
 		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setPassword(password);
			
		}

	@Setter(value = AccessLevel.NONE)
	private String id;
	// id value should have min length of 6
	// we have to write a code to validate the length and assign the value
	
	@Setter(value = AccessLevel.NONE)
	private String firstName;
	
	@Setter(value = AccessLevel.NONE)
	private String lastName;
	
	@Setter(value = AccessLevel.NONE)
	private String email;
	
	@Setter(value = AccessLevel.NONE)
	private String password;
	
	private BigDecimal contactnumber;
	
	public Register() {
		
	}

	//here Main is caller for this
	public void setId(String id) throws InvalidIdLengthException {
		
		if(id.length()<6) {
			
			throw new InvalidIdLengthException("id length is less than 6");
			
		}
		this.id = id;
	}

	public void setFirstName(String firstName) throws InvalidNameException {
		if(firstName ==null || firstName=="" || firstName.length()<2) {
			throw new InvalidNameException("first name is not valid");
		}
		this.firstName = firstName;
	}

	public void setLastName(String lastName) throws InvalidNameException {
		if(lastName ==null || lastName=="" || lastName.length()<2) {
			throw new InvalidNameException("last name is not valid");
		}
		this.lastName = lastName;
	}

	public void setEmail(String email) throws InvalidEmailException {
		//check for email ending with and @
		if(email.endsWith(".com")==false || email.indexOf("@")==-1)
			throw new InvalidEmailException("email invalid");
		this.email = email;
	}

	public void setPassword(String password) throws InvalidPasswordException {
		this.password = password;
	}

	@Override
	public int compareTo(Register o) {
		 //TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
	
	

//	@Override
//	public int hashCode() {
//		return Objects.hash(email, firstName, id, lastName, password);
//	}
//
//	@Override
//	we override to know how to handle it behind the scenes
//	public boolean equals(Object obj) {
//		//this are the 5 points under equals contract
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Register other = (Register) obj;
//		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
//				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
//				&& Objects.equals(password, other.password);
//	}
	
	
	
}
