package com.zee.zee5app;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.Impl.UserServiceImpl;
import com.zee.zee5app.service.Impl.MovieServiceImpl;
import com.zee.zee5app.service.Impl.SeriesServiceImpl;
import com.zee.zee5app.service.Impl.SubscriptionServiceImpl;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.SeriesService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserService userservice;
//		try {
//			userservice = UserServiceImpl.getInstance();
//			Register register=new Register("abbba09","Prateek9","Patnaik9","prateek9@gmail.com","prateek9",new BigDecimal("8298117779"));
////			System.out.println(userservice.deleteUserById("abbba09"));
//			System.out.println(userservice.addUser(register));
//		} catch (IOException | InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException  e) {
//			// TODO Auto-generated catchblock
//			e.printStackTrace();
//		}
		System.out.println("hello");
	}

}
