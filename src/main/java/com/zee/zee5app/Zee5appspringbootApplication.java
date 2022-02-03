package com.zee.zee5app;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.EpisodeRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.Impl.UserServiceImpl;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext=SpringApplication.run(Zee5appspringbootApplication.class, args);
		DataSource dataSource=applicationContext.getBean(DataSource.class);
		System.out.println(dataSource!=null);
//		UserRepository userRepository=applicationContext.getBean(UserRepository.class);
//		UserService userService=applicationContext.getBean(UserService.class);
//		MovieService movieService=applicationContext.getBean(MovieService.class);
//		SeriesService seriesService=applicationContext.getBean(SeriesService.class);
//		Register register;
//		Movie movie;
//		Series series;
//		try {
//			register = new Register("abbba8","Prateek8","Patnaik8","prateek8@gmail.com","prateek8",new BigDecimal("8298117778"));
//			System.out.println(userService.addUser(register));
////			System.out.println(userService.deleteUserById("abbba90"));
//			String cast= "pqr,kacb";
//			movie =new Movie("mov0002",155,"xyz111","comedy","2022-10-10","xyz.com",cast);
//			System.out.println(movieService.addMovie(movie));
//			series=new Series("sereiesxyz",18,"ser0001","comedy","2022-01-22","seriesxyz.com","pq,zx","english",4);
//			System.out.println(seriesService.addSeries(series));
//			
//		} catch (Exception e){
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		UserService service = applicationContext.getBean(UserService.class);
		Register register;
		register = new Register("abbba8","Prateek8","Patnaik8","prateek8@gmail.com","prateek8",new BigDecimal("8298117778"));
		System.out.println(service.addUser(register));
		
		register = new Register("ab00122", "rahu", "sharma", "rahu222@gmail.com", "Jd34g43", null);
		register.setContactnumber(new BigDecimal("9813973123"));
		System.out.println(service.addUser(register));
		
		register = new Register("ab00123", "rohan", "pathak", "rohan67@gmail.com", "Ftbcdgfd", null);
		register.setContactnumber(new BigDecimal("8631973123"));
		System.out.println(service.addUser(register));
		
		register = new Register("ab00124", "prateek", "patnaik", "prats2@gmail.com", "Ggdydfr", null);
		register.setContactnumber(new BigDecimal("981397372"));
		System.out.println(service.addUser(register));

		Optional<Register> register1 = null;

		try {
			register1 = service.getUserById("ab00122");
			if (register1 != null) {
				System.out.println("Record found");
				System.out.println(register1.get());
			} else {
				System.out.println("record is not found");
			}
		} catch (IdNotFoundException | InvalidIdLengthException | InvalidEmailException | InvalidPasswordException
				| InvalidNameException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

		Optional<List<Register>> optional1;
		try {
			optional1 = service.getAllUserDetails();
			if (optional1.isEmpty()) {
				System.out.println("there are no records");
			} else {
				optional1.get().forEach(e -> System.out.println(e));
			}
		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException
				| InvalidPasswordException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		

		try {
			service.deleteUserById("ab00122");
		} catch (IdNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			for (Register register2 : service.getAllUsers()) {
				if (register2 != null)
					System.out.println(register2);
			}
		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException
				| InvalidPasswordException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		MovieService movieService=applicationContext.getBean(MovieService.class);

		Movie movie;
		movie =new Movie("mov0003",105,"xyz991","thriller","2021-11-10","xyz.com","kakak,kkk","english");
		System.out.println(movieService.addMovie(movie));
		
		movie =new Movie("mov0002",155,"xyz111","comedy","2022-10-10","xyz.com","ab,pq","hindi");
		System.out.println(movieService.addMovie(movie));
		
		movie =new Movie("mov0005",160,"xyz181","comedy","2021-10-10","xyz678.com","tab,zpq","english");
		System.out.println(movieService.addMovie(movie));
		
		
		SeriesService seriesService=applicationContext.getBean(SeriesService.class);

		Series series;
		series=new Series("sereiesxyz",18,"ser0001","comedy","2022-01-22","seriesxyz.com","pq,zx","english",4);
		System.out.println(seriesService.addSeries(series));
		
		series=new Series("sereiespqr",12,"ser0007","comedy","2021-01-02","seriespqr.com","tq,zx","english",12);
		System.out.println(seriesService.addSeries(series));
		
		SubscriptionService subscriptionService=applicationContext.getBean(SubscriptionService.class);
		Subscription subscription;
		try {
			subscription=new Subscription("sub0001", "annually", "2022-01-20", "credit", 1499, "active", "true", "2023-01-20", "ab00123");
			System.out.println(subscriptionService.addSubscription(subscription));
			subscription=new Subscription("sub0002", "monthly", "2021-02-10", "debit", 499, "inactive", "false", "2021-03-10", "abbba8");
			System.out.println(subscriptionService.addSubscription(subscription));
		} catch (InvalidAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		EpisodeService episodeService=applicationContext.getBean(EpisodeService.class);
		Episodes episodes;
		try {
			episodes=new Episodes("ser0001", "xyz111", 55, "seriesxyz");
			System.out.println(episodeService.addEpisode(episodes));
			episodes=new Episodes("ser0002", "xyz111", 55, "seriesxyz01");
			System.out.println(episodeService.addEpisode(episodes));
			episodes=new Episodes("ser1000","xyz991",90,"series10hy");
			System.out.println(episodeService.addEpisode(episodes));

		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		applicationContext.close();
	}

}
