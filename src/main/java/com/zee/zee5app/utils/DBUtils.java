package com.zee.zee5app.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component
public class DBUtils {
	//this class is used to get the db connection and to close the connection
	
	//singleton DP not implementing here
	public static DBUtils dbUtils = null;
	static Properties properties = null;

	Connection connection = null;
	private DBUtils() throws IOException {
		Properties properties = loadProperties();
	}
	//private static DBUtils dbUtils;
	
	public Connection getConnection() {
		//get db connection
		
		//Connection connection = null;
		
		try {
			properties = loadProperties();
			
			if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(properties.getProperty("jdbc.url"),
					properties.getProperty("jdbc.username"),
					properties.getProperty("jdbc.password"));
			System.out.println(properties);
			connection.setAutoCommit(false);
			}
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
		
	}
	
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Properties loadProperties() throws IOException {
		//read the properties file
		InputStream inputStream =  DBUtils.class.getClassLoader().getResourceAsStream("application.properties");
		
		Properties properties = new Properties();
		properties.load(inputStream);
		// this will read properties internally
		
		return properties;
	}
	
//	public static void main(String[] args) {
//		DBUtils dbUtils = DBUtils.getInstance();
//		Connection connection = dbUtils.getConnection();
//		System.out.println(connection!=null);
//		
//       				
//	}
//	

}
