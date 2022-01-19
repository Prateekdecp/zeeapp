package com.zee.zee5app.service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;

public class UserService {
	UserRepository repository=UserRepository.getInstance();
	private UserService() {
		// TODO Auto-generated constructor stub
	}
	private static UserService service=null;
	public static UserService getInstance()
	{
		if(service==null)
			service=new UserService();
		return service;
	}
	public String addUser(Register register)
	{
		return this.repository.addUser(register);
	}
	public Register getUserById(String id)
	{
		return this.repository.getUserById(id);
	}
	public Register[] getAllUsers()
	{
		return this.repository.getUsers();
	}
	public String deleteUser(String id)
	{
		return this.repository.deleteUser(id);
	}
}
