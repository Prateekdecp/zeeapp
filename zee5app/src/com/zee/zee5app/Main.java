package com.zee.zee5app;

import java.security.Provider.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.UserService2;
import com.zee.zee5app.service.impl.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method added 
		Register register=new Register();
		register.setFirstName("Prateek");
		register.setEmail("prateek@gmail.com");
		register.setLastName("Patnaik");
		System.out.println(register);		
		UserService2 userservice=UserServiceImpl.getInstance();
		Register register1=new Register();
		register1.setId("abba14");
		register1.setEmail("aba14"+"@gmail.com");
		register1.setFirstName("Prateek14");
		register1.setLastName("Patnaik14");
		register1.setPassword("prateek14");
		System.out.println(userservice.addUser(register1));
		for(Register register3:userservice.getAllUsers())
			System.out.println(register3);
	}

}
