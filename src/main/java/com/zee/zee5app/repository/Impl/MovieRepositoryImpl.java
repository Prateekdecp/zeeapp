package com.zee.zee5app.repository.Impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.naming.NameNotFoundException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.utils.DBUtils;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
	@Autowired
	DataSource dataSource;
	public MovieRepositoryImpl()throws IOException {
		
	}
	
	
	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertStatement = "insert into movies"+
		       "(movieid, moviename, moviecategory, moviereleasedate, movietrailer ,movielength,moviecast)"
		       +"values(?,?,?,?,?,?,?)";
		
		
		try {
			connection = dataSource.getConnection();
			preparedStatement=connection.prepareStatement(insertStatement);
			preparedStatement.setString(1,movie.getId());
			preparedStatement.setString(2,movie.getMovieName());
			preparedStatement.setString(3,movie.getCategory());
			preparedStatement.setString(4,movie.getReleaseDate());
			preparedStatement.setString(5,movie.getTrailer());
			preparedStatement.setLong(6,movie.getLength());
			String casts[]=movie.getCast();
			String castquery="";
			for(String cast:casts)
				castquery+=cast+",";
			castquery=castquery.substring(0, castquery.length()-1);
			preparedStatement.setString(7,castquery);
			int res=preparedStatement.executeUpdate();
			if(res>0)
			{
				connection.commit();
				return "sucessfully added to movie database";
			}
			else
			{
				connection.rollback();
				return "failed to add data";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "fail to add movie";
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteStatement = "delete from movies where movieid=?";
		
		
		
			try {
				connection = dataSource.getConnection();

				preparedStatement = connection.prepareStatement(deleteStatement);

				preparedStatement.setString(1,id);
				int result = preparedStatement.executeUpdate();
				if(result>0)
				{
					connection.commit();
					return "deleted the movie successfully";
				}
				else
				{
					connection.close();
					return "failed to delete";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	return "failure";
	}

	@Override
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String deleteStatement = "select * from movies where movieid=?";
		
		
		try {
			connection = dataSource.getConnection();
			preparedStatement=connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1,id );
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				Movie movie=new Movie();
				movie.setId(resultSet.getString("movieid"));
				movie.setMovieName(resultSet.getString("moviename"));
				movie.setCategory(resultSet.getString("category"));
				movie.setReleaseDate(resultSet.getString("releasedate"));
				movie.setTrailer(resultSet.getString("trailer"));
				movie.setLength(resultSet.getLong("movielength"));
				String casts[]=resultSet.getString("moviecast").split(",");
				movie.setCast(casts);
				return Optional.of(movie);
			}
		} catch (SQLException | InvalidIdLengthException | NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<Movie>> getAllMovie() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String deleteStatement = "select * from movies";
		
		ArrayList<Movie> arraylist=new ArrayList<Movie>();
		try {
			connection = dataSource.getConnection();
			preparedStatement=connection.prepareStatement(deleteStatement);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Movie movie=new Movie();
				movie.setId(resultSet.getString("movieid"));
				movie.setMovieName(resultSet.getString("moviename"));
				movie.setCategory(resultSet.getString("category"));
				movie.setReleaseDate(resultSet.getString("releasedate"));
				movie.setTrailer(resultSet.getString("trailer"));
				movie.setLength(resultSet.getLong("movielength"));
				String casts[]=resultSet.getString("moviecast").split(",");
				movie.setCast(casts);
				arraylist.add(movie);
			}
			return Optional.of(arraylist);
		} catch (SQLException | InvalidIdLengthException | NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}
}

//	@Override
//	public Optional<Movie> getMovieById(String id) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		Movie movie2 = null;
//		for (Movie movie : set) {
//			if(movie.getId().equals(id)) {
//				movie2 = movie;
//			    break;
//		}
//			
//		}
//	 return Optional.of(Optional.ofNullable(movie2).orElseThrow(()-> new IdNotFoundException("movie id not found")));
//				
//	}
//
//	@Override
//	public List<Movie> getAllMovie() {
//		// TODO Auto-generated method stub
//        List<Movie> arrlist = new ArrayList(set);
//        Collections.sort(arrlist);
//        return arrlist;
//        
////        return new ArrayList<>(set.descendingSet())
//        
//
//	}
//	
//	

	