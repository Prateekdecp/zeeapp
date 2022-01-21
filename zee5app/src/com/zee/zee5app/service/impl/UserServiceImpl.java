package com.zee.zee5app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository2;
import com.zee.zee5app.repository.impl.UserRepositoryImpl;
import com.zee.zee5app.service.UserService2;

import exception.IdNotFoundException; 

public class UserServiceImpl implements UserService2 {

	
	private UserServiceImpl()
	{
		
	}
	
	private static UserService2 userservice;
	public static UserService2 getInstance()
	{
		if(userservice==null)
			userservice=new UserServiceImpl();
		return userservice;
	}
	
	UserRepository2 userrepository=UserRepositoryImpl.getInstance();
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		return userrepository.addUser(register);
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
        return userrepository.updateUser(id, register);
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return userrepository.getUserById(id);
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		return userrepository.getAllUsers();
	}
	@Override
	public List<Register> GetAllUser() {
		// TODO Auto-generated method stub
		return userrepository.GetAllUser();
	}
	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return userrepository.deleteUserById(id);
	}

	

}
