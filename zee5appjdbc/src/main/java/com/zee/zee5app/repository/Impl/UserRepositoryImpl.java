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

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.utils.PasswordUtils;
@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	DataSource dataSource;
	@Autowired
	LoginRepository loginrepository;
	public UserRepositoryImpl() throws IOException{
		
	}
	
	@Autowired
	PasswordUtils passwordUtils;
	
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		//the user details should be stored in database
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertStatement = "insert into register"+
		       "(regid, firstName, lastName, email, password,contactnumber)"
		       +"values(?,?,?,?,?,?)";
		
		
		try {
			connection = dataSource.getConnection();

			preparedStatement = connection.prepareStatement(insertStatement);
			
			preparedStatement.setString(1, register.getId());
			preparedStatement.setString(2, register.getFirstName());
			preparedStatement.setString(3, register.getLastName());
			preparedStatement.setString(4, register.getEmail());
			preparedStatement.setBigDecimal(6, register.getContactnumber());
			
			String salt = passwordUtils.getSalt(30);
			String encryptedPassword = passwordUtils.generateSecurePassword(register.getPassword(), salt);
			preparedStatement.setString(5, encryptedPassword);
			
			
			
			int result = preparedStatement.executeUpdate();
			
			if(result>0) {
				connection.commit();
				Login login = new Login();
				login.setUserName(register.getEmail());
				login.setPassword(encryptedPassword);
				login.setRegId(register.getId());
				login.setRole(ROLE.ROLE_USER);
				
				String result2 = loginrepository.addCredentials(login);
//				connection.commit();
				if(result2.equals("success")) {
//					connection.commit();
					return "user added successfully";
					
				}
				else {
					connection.rollback();
					return "fail";
				}
			}
			else {
				connection.rollback();
				return "fail";
			}
				} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "fail";
		}
	}
	
	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidEmailException, InvalidPasswordException, InvalidNameException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String selectStatement = "select * from register where regId=?";
		
		
		try {
			connection=dataSource.getConnection();
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);
			
			resultSet = preparedStatement.executeQuery();
			
			
			if (resultSet.next()) {
				
				
				Register register = new Register();
				register.setId(resultSet.getString("regid"));
				register.setFirstName(resultSet.getString("firstName"));
				register.setLastName(resultSet.getString("lastName"));
				register.setEmail(resultSet.getString("email"));
				register.setPassword(resultSet.getString("password"));
				register.setContactnumber(resultSet.getBigDecimal("contactnumber"));
				return Optional.of(register);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return "fail12";
		}
		
		return Optional.empty();
	}
	
	@Override
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		Optional<List<Register>> optional = getAllUserDetails();
		if(optional.isEmpty()) {
			return null;
		}
		else {
			List<Register> list = optional.get();
			Register[] registers = new Register[list.size()];
			return list.toArray(registers);
		}
		
	}
	
	@Override
	public Optional<List<Register>> getAllUserDetails() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Register> arraylist = new ArrayList<>();
		
		String selectStatement = "select * from register";
		
		
		try {
			connection=dataSource.getConnection();
			preparedStatement = connection.prepareStatement(selectStatement);
			//preparedStatement.setString(1);
			
			
			resultSet = preparedStatement.executeQuery();
			
			
			while(resultSet.next()) {
			
				Register register = new Register();
				register.setId(resultSet.getString("regid"));
				register.setFirstName(resultSet.getString("firstName"));
				register.setLastName(resultSet.getString("lastName"));
				register.setEmail(resultSet.getString("email"));
				register.setPassword(resultSet.getString("password"));
				register.setContactnumber(resultSet.getBigDecimal("contactnumber"));
				arraylist.add(register);
			}
			return Optional.ofNullable(arraylist);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Optional.empty();
	}
	
	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteStatement = "delete from register where regid=?";
		
		
		try {
			connection=dataSource.getConnection();

			preparedStatement = connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1,id);
			
			int result = preparedStatement.executeUpdate();
			if(result>0) {
				connection.commit();
				return "record deleted";
			}
			else {
				connection.rollback();
				return "fail";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return "fail12";
		}
		
		return "fail";
	}
	
	
	
}