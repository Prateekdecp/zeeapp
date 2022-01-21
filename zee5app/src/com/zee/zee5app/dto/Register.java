package com.zee.zee5app.dto;

//arrayList
//hashset movies
//treeset series

//exception-namenotfound,locationnotfound,invalidamount


import java.util.Comparator;
import java.util.Objects;

import exception.InvalidEmailException;
import exception.InvalidIdException;
import exception.InvalidNameException;
import exception.InvalidPasswordException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@ToString
@EqualsAndHashCode
@NoArgsConstructor
//@AllArgsConstructor
@Setter
@Getter
public class Register implements Comparable<Register>
{	
	public Register (String id, String firstName, String lastName, String email, String password)
	throws InvalidIdException,InvalidNameException, 
	InvalidEmailException, InvalidPasswordException{
		super();
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail (email);
		this.setPassword(password);
	}

	@Setter(value = AccessLevel.NONE)
	private String id;
	@Setter(value = AccessLevel.NONE)
	private String firstName;
	@Setter(value = AccessLevel.NONE)
	private String lastName;
	@Setter(value = AccessLevel.NONE)
	private String email;
	@Setter(value = AccessLevel.NONE)
	private String password;
	
	public void setId (String id) throws InvalidIdException {
		if(id.length()<6)
			throw new InvalidIdException("There is some error");
		this.id = id;
	}
	public void setFirstName(String firstName) throws InvalidNameException {
		if(firstName==null || firstName=="" || firstName.length()<2)
		{
			throw new InvalidNameException("firstname is wrong");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) throws InvalidNameException {
		if(lastName==null || lastName=="" || lastName.length()<2)
		{
			throw new InvalidNameException("lastname is wrong");
		}
		this.lastName = lastName;
	}
	public void setEmail(String email) throws InvalidEmailException {
		if(email==null || email=="" || email.length()<2)
		{
			throw new InvalidEmailException("email is invalid");
		}
		this.email = email;
	}
	public void setPassword(String password) throws InvalidPasswordException {
		if(password==null || password=="" || password.length()<2)
		{
			throw new InvalidPasswordException("password is invalid");
		}
		this.password = password;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Register other = (Register) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password);
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password);
	}
	
	@Override
	public int compareTo(Register o) {
		// TODO Auto-generated method stub
		return this.getFirstName().length()-o.getFirstName().length();
	}

	
}
