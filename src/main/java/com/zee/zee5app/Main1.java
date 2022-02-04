package com.zee.zee5app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.aspectj.apache.bcel.classfile.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.MovieExistsException;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.RoleService;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.utils.FileUtils;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class,
				args);

//		userRepository=applicationContext.getBean(UserRepository.class);
//		System.out.println(userRepository.existsByEmailAndContactnumber("prateek8@gmail.com",new BigDecimal("8298117778")));
//		
//		MovieRepository movieRepository=applicationContext.getBean(MovieRepository.class);
//		System.out.println(movieRepository.existsByMovieName("mov0002"));
//		System.out.println(movieRepository.findByMovieNameAndLanguage("mov0002", "hindi"));
//		
//		System.out.println(movieRepository.findByMovieName("mov0003"));
//		System.out.println(movieRepository.findByCast("tab,zpq"));
//		System.out.println(movieRepository.findByMovieNameAndReleaseDate("mov0002", "2022-10-10"));

//		Role role=new Role();
//		role.setRoleName(EROLE.ROLE_ADMIN);
//		
//		Role role1=new Role();
//		role1.setRoleName(EROLE.ROLE_USER);
//		
//		RoleService roleService=applicationContext.getBean(RoleService.class);
//		roleService.addRole(role);
//		roleService.addRole(role1);
//		
//		RoleRepository roleRepository=applicationContext.getBean(RoleRepository.class);
//		UserService service = applicationContext.getBean(UserService.class);
//		SubscriptionService subscriptionService=applicationContext.getBean(SubscriptionService.class);
//		
//		Register register;
//		register = new Register("abbba93","Prateek93","Patnaik93","prateek93@gmail.com","prateek93",new BigDecimal("8298117793"),null,null);
//		Set<Role> roles=new HashSet<>();
//		roles.add(roleRepository.findById(1).get());
//		roles.add(roleRepository.findById(2).get());
//		register.setRoles(roles);
////			System.out.println(service.addUser(register));
//		Subscription subscription1=new Subscription("sub0001", "annually", "2022-01-20", "credit", 1499, "active", "true", "2023-01-20", register);
//		try {
//			subscriptionService.addSubscription(subscription1);
//		} catch (InvalidAmountException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		SeriesService seriesService=applicationContext.getBean(SeriesService.class);
//		EpisodeService episodeService=applicationContext.getBean(EpisodeService.class);
//		
//		Series series1, series2;
//		series1 = new Series("sereiesxyz", 18, "ser0001", "comedy", "2022-01-22", "seriesxyz.com", "pq,zx", "english",
//				4, null);
//		System.out.println(seriesService.addSeries(series1));

//		series2 = new Series("sereiespqr", 15, "ser0002", "action", "2021-06-03", "seriespqr.com", "ts,py", "spanish",
//				10, null);
//		System.out.println(seriesService.addSeries(series2));

//		Episodes episodes1=new Episodes("epi0001", 55,"epixyz", series1);
//		try {
//			episodeService.addEpisode(episodes1);
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		MovieService movieService = applicationContext.getBean(MovieService.class);

		// STORING SINGLE FILES//

//		Movie movie=new Movie("pushpa", 155, "mov0001", "comedy", "2022-01-03", null, "allu arjun", "telegu");
//		FileInputStream fileInputStream=null;
//		try {
//			fileInputStream=new FileInputStream("C:\\Users\\prateek.patnaik\\Downloads\\song.mp3");
//			long fileSize=new File("C:\\Users\\prateek.patnaik\\Downloads\\song.mp3").length();
//			byte[] allBytes=new byte[(int)fileSize];
//			fileInputStream.read(allBytes);
//			movie.setTrailer(allBytes);
//			movieService.addMovie(movie);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			try {
//				fileInputStream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//		FileOutputStream fileOutputStream=null;
//		try {
//			Optional<Movie> optional = movieService.getMovieById("mov0001");
//			if (optional.isEmpty()) {
//				System.out.println("movie not found");
//			} else {
//				Movie movie=optional.get();
//				fileOutputStream=new FileOutputStream("C:\\Users\\prateek.patnaik\\Downloads\\read\\song1.mp3");
//				fileOutputStream.write(movie.getTrailer());
//				
//			}
//		} catch (IdNotFoundException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				fileOutputStream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

//		Movie movie = new Movie("pushpa", 155, "mov0001", "comedy", "2022-01-03", null, "allu arjun", "telegu");
//		FileInputStream fileInputStream = null;
//		FileOutputStream fileOutputStream = null;
//		try {
//			File file = new File("C:\\Users\\prateek.patnaik\\Downloads\\song.mp3");
//			fileInputStream = new FileInputStream(file);
//			long fileSize = file.length();
//			byte[] allBytes = new byte[(int) fileSize];
//			movie.setTrailer("C:\\Users\\prateek.patnaik\\Downloads\\movieStore\\" + file.getName());
//			String res = movieService.addMovie(movie);
//			if (res.equals("success")) {
//				fileOutputStream = new FileOutputStream(
//						"C:\\Users\\prateek.patnaik\\Downloads\\movieStore\\" + file.getName());
//				fileInputStream.read(allBytes);
//				fileOutputStream.write(allBytes);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				fileInputStream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		EpisodeService episodeService = applicationContext.getBean(EpisodeService.class);
//		Episodes episode2 = new Episodes("epi0002", 65, "kkpyezy", series1, null);
//
//		
//		
//		FileInputStream fileInputStream = null;
//		FileOutputStream fileOutputStream = null;
//		try {
//			File file = new File("C:\\Users\\prateek.patnaik\\Downloads\\some_song.mp3");
//			fileInputStream = new FileInputStream(file);
//			long fileSize = file.length();
//			byte[] allBytes = new byte[(int) fileSize];
//			episode2.setTrailer("C:\\Users\\prateek.patnaik\\Downloads\\movieStore\\" + file.getName());
//			String res = episodeService.addEpisode(episode2);
//			if (res.equals("added episodes successfully")) {
//				fileOutputStream = new FileOutputStream(
//						"C:\\Users\\prateek.patnaik\\Downloads\\movieStore\\" + file.getName());
//				fileInputStream.read(allBytes);
//				fileOutputStream.write(allBytes);
//			}
//		} catch (IOException | IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				fileInputStream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}

//		applicationContext.close();

	}
}
