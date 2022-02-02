package com.zee.zee5app;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.Impl.UserServiceImpl;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext=SpringApplication.run(Zee5appspringbootApplication.class, args);
		DataSource dataSource=applicationContext.getBean(DataSource.class);
		System.out.println(dataSource!=null);
		UserRepository userRepository=applicationContext.getBean(UserRepository.class);
		UserService userService=applicationContext.getBean(UserService.class);
		MovieService movieService=applicationContext.getBean(MovieService.class);
		Register register;
		Movie movie;
		try {
//			register = new Register("abbba8","Prateek8","Patnaik8","prateek8@gmail.com","prateek8",new BigDecimal("8298117778"));
//			System.out.println(userService.addUser(register));
////			System.out.println(userService.deleteUserById("abbba90"));
			String cast= "pqr,kacb";
			movie =new Movie("mov0002",155,"xyz111","comedy","2022-10-10","xyz.com",cast);
			System.out.println(movieService.addMovie(movie));
		} catch (Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		applicationContext.close();
	}

}
