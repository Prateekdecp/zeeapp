package com.zee.zee5app;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.exception.MovieExistsException;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.UserRepository;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext applicationContext=SpringApplication.run(Zee5appspringbootApplication.class, args);
		UserRepository userRepository=applicationContext.getBean(UserRepository.class);
		System.out.println(userRepository.existsByEmailAndContactnumber("prateek8@gmail.com",new BigDecimal("8298117778")));
		
		MovieRepository movieRepository=applicationContext.getBean(MovieRepository.class);
		System.out.println(movieRepository.existsByMovieName("mov0002"));
		System.out.println(movieRepository.findByMovieNameAndLanguage("mov0002", "hindi"));
		
		System.out.println(movieRepository.findByMovieName("mov0003"));
		System.out.println(movieRepository.findByCast("tab,zpq"));
		System.out.println(movieRepository.findByMovieNameAndReleaseDate("mov0002", "2022-10-10"));
		applicationContext.close();
		
		
	}

}
