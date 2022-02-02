package com.zee.zee5app.repository.Impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.utils.PasswordUtils;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

	
	@Autowired
	DataSource dataSource;

	public LoginRepositoryImpl() throws IOException {
	}

//	

	@Override
	public String addCredentials(Login login) {
		String insertQuery = "insert into login (username, password, regid,role)" + "values(?,?,?,?)";
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement prepStatement = connection.prepareStatement(insertQuery);
			prepStatement.setString(1, login.getUserName());
			prepStatement.setString(2, login.getPassword());
			prepStatement.setString(3, login.getRegId());
			prepStatement.setString(4, login.getRole().toString());
			int result = prepStatement.executeUpdate();
//			connection.commit();
			if (result > 0) {
				connection.commit();
				return "success";
			} else {
				connection.rollback();
				return "fail";
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return "fail";
	}

	@Override
	public String deleteCredentials(String userName) {
		String delQuery = "DELETE FROM login where username=?";
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement prepStatement = connection.prepareStatement(delQuery);
			prepStatement.setString(1, userName);
			int result = prepStatement.executeUpdate();
			if (result > 0)
				return "success";
			else
				return "fail";

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "fail";
	}

	@Override
	public String changePassword(String userName, String password) {
		String changequery="update login set password=? where usernmae=?";
		PreparedStatement preparedStatement=null;
		try {
			Connection connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement(changequery);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, userName);
			int res=preparedStatement.executeUpdate();
			if(res>0)
			{
				connection.commit();
				return "success";
			}
			else
			{
				connection.rollback();
				return "failure";
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String changeRole(String username, ROLE role) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement=null;
		String updateStatement="update login set role=? where username=?";
		try {
			Connection connection = dataSource.getConnection();
			preparedStatement=connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, role.toString());
			preparedStatement.setString(2, username);
			
			int result=preparedStatement.executeUpdate();
			if(result>0)
			{
				connection.commit();
				return "success";
			}
			else
			{
				connection.rollback();
				return "failure";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
	}

}

