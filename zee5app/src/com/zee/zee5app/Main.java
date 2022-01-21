package com.zee.zee5app;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.UserService2;
import com.zee.zee5app.service.impl.UserServiceImpl;

import exception.IdNotFoundException;
import exception.InvalidEmailException;
import exception.InvalidIdException;
import exception.InvalidNameException;
import exception.InvalidPasswordException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method added 
		Register register=new Register();
		UserService2 userservice=UserServiceImpl.getInstance();
		
//		try {
//			Register register5=new Register("abba14","Prateek2","Patnaik2","prateek2@gmail.com","rateek2");
//		} catch (InvalidIdException | InvalidNameException | InvalidEmailException | InvalidPasswordException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace(); 
//		}
//
//
//		try {
//			register.setFirstName("Prateek");
//		} catch (InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			register.setEmail("prateek@gmail.com");
//		} catch (InvalidEmailException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		try {
//			register.setLastName("Patnaik");
//		} catch (InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(register);		
//		Register register1=new Register();
//		
//		
//		try {
//			register1.setId("abba14");
//		} catch (InvalidIdException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		try {
//			register1.setEmail("aba14"+"@gmail.com");
//		} catch (InvalidEmailException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		
//		try {
//			register1.setFirstName("Prateek14");
//		} catch (InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		try {
//			register1.setLastName("Patnaik14");
//		} catch (InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		try {
//			register1.setPassword("prateek14");
//		} catch (InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(userservice.addUser(register1));
//		for(Register register3:userservice.getAllUsers())
//			System.out.println(register3);
//		
		for(int i=1;i<=20;i++)
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
//		try {
//			Optional<Register> optional=userservice.getUserById("abbba14");
//			System.out.println(optional);
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (optional.isPresent()) {
//			System.out.println("user is "+optional.get());
//		}
//		else
//			System.out.println("id not found");
		
		userservice.GetAllUser().forEach(e->System.out.println(e));
		
	}

}
