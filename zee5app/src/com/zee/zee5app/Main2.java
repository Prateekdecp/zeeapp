package com.zee.zee5app;

import com.zee.zee5app.dto.Register;

import exception.InvalidEmailException;
import exception.InvalidIdException;
import exception.InvalidNameException;
import exception.InvalidPasswordException;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Register register=new Register("abba13","Prateek1","Patnaik1","prateek1@gmail.com","rateek1");
			System.out.println(register);
			System.out.println(register.toString());
			System.out.println(register.hashCode());
			Register register2=new Register("abba13","Prateek1","Patnaik1","prateek1@gmail.com","rateek1");
			System.out.println(register2);
			System.out.println(register2.toString());
			System.out.println(register2.hashCode());
			System.out.println("equals method call"+ register.equals(register2));
			
		} catch (InvalidIdException | InvalidNameException | InvalidEmailException | InvalidPasswordException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

}
