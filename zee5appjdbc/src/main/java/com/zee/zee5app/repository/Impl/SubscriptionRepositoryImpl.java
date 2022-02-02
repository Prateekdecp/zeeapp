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
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.utils.DBUtils;

@Repository
public class SubscriptionRepositoryImpl implements SubscriptionRepository {

	@Autowired
	DataSource dataSource;
	
	public SubscriptionRepositoryImpl() throws IOException {

	}

	

	@Override
	public String addSubscription(Subscription subscription) throws InvalidAmountException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		String insertStatement = "insert into subscription values"
				+ "(subid,dop,status,paymentmode,autorenewal,expirydate,regid,type,amount)" + "(?,?,?,?,?,?,?,?,?)";

		try {
			Connection connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, subscription.getId());
			preparedStatement.setString(2, subscription.getDateOfPurchase());
			preparedStatement.setString(3, subscription.getStatus());
			preparedStatement.setString(4, subscription.getPaymentMode());
			preparedStatement.setString(5, subscription.getAutoRenewal());
			preparedStatement.setString(6, subscription.getExpiryDate());
			preparedStatement.setString(7, subscription.getRegid());
			preparedStatement.setString(8, subscription.getType());
			preparedStatement.setLong(9, subscription.getAmount());

			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
				return "success";
			} else {
				connection.rollback();
				return "failure";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";

	}

	@Override
	public String deleteSubscription(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		String deleteStatement = "delete from subscription where regid=?";

		try {
			Connection connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1, id);
			int res = preparedStatement.executeUpdate();
			if (res > 0) {
				connection.commit();
				return "record deleted";
			} else {
				connection.rollback();
				return "failure";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "failure";
	}

	@Override
	public String modifySubscription(String id, Subscription subscription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String selectStatement = "select * from subscription where regid=?";


		try {
			Connection connection = dataSource.getConnection();

			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				Subscription subscription = new Subscription();
				subscription.setId(resultSet.getString("subid"));
				subscription.setDateOfPurchase(resultSet.getString("dop"));
				subscription.setStatus(resultSet.getString("status"));
				subscription.setPaymentMode(resultSet.getString("paymentmode"));
				subscription.setAutoRenewal(resultSet.getString("autorenewal"));
				subscription.setExpiryDate(resultSet.getString("expirydate"));
				subscription.setRegid(resultSet.getString("regid"));
				subscription.setAmount(resultSet.getInt("amount"));
				subscription.setType(resultSet.getString("type"));
				return Optional.of(subscription);
			}

		} catch (SQLException | InvalidIdLengthException | InvalidAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// return "fail12";
		} 
		return Optional.empty();
	}

	@Override
	public Optional<List<Subscription>> getAllSubscription() {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String selectStatement = "select * from subscription";

		ArrayList<Subscription> arrayList=new ArrayList<Subscription>();
		try {
			Connection connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(selectStatement);

			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {

				Subscription subscription = new Subscription();
				subscription.setId(resultSet.getString("subid"));
				subscription.setDateOfPurchase(resultSet.getString("dop"));
				subscription.setStatus(resultSet.getString("status"));
				subscription.setPaymentMode(resultSet.getString("paymentmode"));
				subscription.setAutoRenewal(resultSet.getString("autorenewal"));
				subscription.setExpiryDate(resultSet.getString("expirydate"));
				subscription.setRegid(resultSet.getString("regid"));
				subscription.setAmount(resultSet.getInt("amount"));
				subscription.setType(resultSet.getString("type"));
				arrayList.add(subscription);
			}
			return Optional.of(arrayList);

		} catch (SQLException | InvalidIdLengthException | InvalidAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// return "fail12";
		} 
		return Optional.empty();
	}

}