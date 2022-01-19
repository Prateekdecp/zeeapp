package com.zee.zee5app;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.movieService;
import com.zee.zee5app.service.seriesService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// shuttle change by 
		// has and add
		Register register=new Register();
		register.setFirstName("Prateek");
		register.setEmail("prateek@gmail.com");
		register.setLastName("Patnaik");
		System.out.println(register);
		Login login=new Login();
		UserService service=UserService.getInstance();
		for(int i=0;i<12;i++)
		{
			Register register1=new Register();
			register1.setId("abba"+i);
			register1.setEmail("aba"+i+"@gmail.com");
			register1.setFirstName("Prateek"+i);
			register1.setLastName("Patnaik");
			register1.setPassword("prateek"+i);
			String res=service.addUser(register1);
//			System.out.println(res);
		}
		System.out.println(service.getUserById("abba2")!=null);
		for(Register register3:service.getAllUsers())
			System.out.println(register3);
		System.out.println(service.deleteUser("abba2"));
		for(Register register3:service.getAllUsers())
			System.out.println(register3);
		SubscriptionService subscriptionservice=SubscriptionService.getInstance();
		movieService movieservice=movieService.getInstance();
		seriesService seriesservice=seriesService.getInstance();
		
	}

}
