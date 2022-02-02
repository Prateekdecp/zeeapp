package com.zee.zee5app.repository.Impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.utils.DBUtils;

@Repository
public class SeriesRepositoryImpl implements SeriesRepository {

	@Autowired
	DataSource dataSource;
	
	public SeriesRepositoryImpl() throws IOException{
		
	}

	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertStatement = "insert into series"+
		       "(seriesid, name, category, releasedate, trailer ,language,cast,length)"
		       +"values(?,?,?,?,?,?,?)";
		
		
		try {
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement(insertStatement);
			preparedStatement.setString(1,series.getId());
			preparedStatement.setString(2,series.getSeriesName());
			preparedStatement.setString(3,series.getCategory());
			preparedStatement.setString(4,series.getReleaseDate());
			preparedStatement.setString(5,series.getTrailer());
			preparedStatement.setString(6,series.getLangauage());

			preparedStatement.setLong(8,series.getLength());
			String casts[]=series.getCast();
			String castquery="";
			for(String cast:casts)
				castquery+=cast+",";
			castquery=castquery.substring(0, castquery.length()-1);
			preparedStatement.setString(7,castquery);
			int res=preparedStatement.executeUpdate();
			if(res>0)
			{
				connection.commit();
				return "sucessfully added to series database";
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
		
		
		
		return "fail to add series";
	}

	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteStatement = "delete from series where seriesid=?";
		
		
			try {
				connection=dataSource.getConnection();

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
	public String modifySeries(String id, Series series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String deleteStatement = "select * from movies where movieid=?";
		
		
		try {
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1,id );
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				Series series=new Series();
				series.setId(resultSet.getString("seriesid"));
				series.setSeriesName(resultSet.getString("name"));
				series.setCategory(resultSet.getString("category"));
				series.setReleaseDate(resultSet.getString("releasedate"));
				series.setTrailer(resultSet.getString("trailer"));
				series.setLangauage(resultSet.getString("language"));
				String casts[]=resultSet.getString("cast").split(",");
				series.setCast(casts);
				series.setLength(resultSet.getLong("length"));
				return Optional.of(series);
			}
		} catch (SQLException | InvalidIdLengthException | NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<Series>> getAllSeries() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String deleteStatement = "select * from movies where movieid=?";
		ArrayList<Series> arraylist=new ArrayList<>();
		
		try {
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement(deleteStatement);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Series series=new Series();
				series.setId(resultSet.getString("seriesid"));
				series.setSeriesName(resultSet.getString("name"));
				series.setCategory(resultSet.getString("category"));
				series.setReleaseDate(resultSet.getString("releasedate"));
				series.setTrailer(resultSet.getString("trailer"));
				series.setLangauage(resultSet.getString("language"));
				String casts[]=resultSet.getString("cast").split(",");
				series.setCast(casts);
				series.setLength(resultSet.getLong("length"));
				arraylist.add(series);
			}
			return Optional.of(arraylist);

		} catch (SQLException | InvalidIdLengthException | NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}
//
//	@Override
//	public Optional<Series> getSeriesById(String id) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		Series series2 = null;
//		for (Series series : set) {
//			if(series.getId().equals(id)) {
//				series2 = series;
//			    break;
//		}
//			
//		}
//	 return Optional.of(Optional.ofNullable(series2).orElseThrow(()-> new IdNotFoundException("series id not found")));
//	}
//
//	@Override
//	public List<Series> getAllSeries() {
//		// TODO Auto-generated method stub
//        List<Series> arrlist = new ArrayList<>(set);
//        Collections.sort(arrlist);
//        return arrlist;
//	}
//	

	
	
	
	
//	
}
