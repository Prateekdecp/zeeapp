package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Register;

public class UserRepository {
	private Register[] registers=new Register[10];
	private static int count=0;
	private UserRepository() {
		// TODO Auto-generated constructor stub
	}
	
	//get all users
	public Register[] getUsers()
	{
		return registers;
	}
	
	//delete user
	public String deleteUser(String id)
	{
		Register[] temp=new Register[registers.length];
		boolean flag=false;
		for(int i=0,k=0;i<registers.length;i++)
		{
			if(registers[i]!=null && registers[i].getId().equals(id))
			{
				flag=true;
				continue;
			}
			else
			{
				temp[k++]=registers[i];
			}
		}
		registers=temp;
		return flag?"success":"id was not available";
	}
	
	//update user details
	public String updateUser(String id,Register register)
	{
		for(Register register1:registers)
		{
			if(register1!=null && register1.getId().equals(id))
			{
				register1=register;
				return "success";
			}
		}
		return "id does not exist";
	}
	
	//get an existing user by his/her id
	public Register getUserById(String id)
	{
		for (Register register : registers) {
			if(register!=null && register.getId().equals(id))
				return register;
		}
		return null;
	}
	
	// add new user to db
	public String addUser(Register register)
	{
		if(count==registers.length)
		{
			Register temp[]=new Register[registers.length*2];
			System.arraycopy(registers, 0, temp, 0, registers.length);
			registers=temp;
		}
		registers[count++]=register;
		return "success";
			 
	}
	private static UserRepository repo;
	public static UserRepository getInstance()
	{
		if(repo==null)
			repo=new UserRepository();
		return repo;
	}
}
