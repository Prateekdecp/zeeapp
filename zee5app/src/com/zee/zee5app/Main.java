package com.zee.zee5app;

import java.security.Provider.Service;
import java.util.Optional;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.UserService2;
import com.zee.zee5app.service.impl.UserServiceImpl;

import exception.InvalidEmailException;
import exception.InvalidIdException;
import exception.InvalidNameException;
import exception.InvalidPasswordException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method added 
		Register register=new Register();
		
		try {
			Register register4=new Register("abba13","Prateek1","Patnaik1","prateek1@gmail.com","rateek1");
		} catch (InvalidIdException | InvalidNameException | InvalidEmailException | InvalidPasswordException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
		}
		catch (Throwable e) {
			// TODO: handle exception
		}
		
		try {
			Register register5=new Register("abba14","Prateek2","Patnaik2","prateek2@gmail.com","rateek2");
		} catch (InvalidIdException | InvalidNameException | InvalidEmailException | InvalidPasswordException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace(); 
		}


		try {
			register.setFirstName("Prateek");
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			register.setEmail("prateek@gmail.com");
		} catch (InvalidEmailException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			register.setLastName("Patnaik");
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(register);		
		UserService2 userservice=UserServiceImpl.getInstance();
		Register register1=new Register();
		
		
		try {
			register1.setId("abba14");
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			register1.setEmail("aba14"+"@gmail.com");
		} catch (InvalidEmailException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			register1.setFirstName("Prateek14");
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			register1.setLastName("Patnaik14");
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			register1.setPassword("prateek14");
		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(userservice.addUser(register1));
		for(Register register3:userservice.getAllUsers())
			System.out.println(register3);
		
		for(int i=0;i<20;i++)
		{
			Register register2=new Register();
			try {
				register2.setId("abbba"+i);
				register2.setEmail("abbba"+i+"@gmail.com");
				register2.setFirstName("prats"+i);
				register2.setLastName("pat"+i);
				register2.setPassword("Prateek"+i);
			} catch (InvalidIdException | InvalidEmailException | InvalidNameException | InvalidPasswordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			userservice.addUser(register2);
		}
		Optional<Register> optional=userservice.getUserById("abbba14");
		if (optional.isPresent()) {
			System.out.println("user is "+optional.get());
		}
		else
			System.out.println("id not found");
	}

}
