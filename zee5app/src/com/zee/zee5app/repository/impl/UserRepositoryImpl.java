package com.zee.zee5app.repository.impl;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository2;

public class UserRepositoryImpl implements UserRepository2 {
	private Register[] registers=new Register[10];
	private static int count=0;
	private UserRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static UserRepository2 repository;
	
	public static UserRepository2 getInstance()
	{
		if(repository==null)
			repository=new UserRepositoryImpl();
		return repository;
	}
	
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		if(count==registers.length)
		{
			Register temp[]=new Register[registers.length*2];
			System.arraycopy(registers, 0, temp, 0, registers.length);
			registers=temp;
		}
		registers[count++]=register;
		return "success";
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
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

	@Override
	public Register getUserById(String id) {
		// TODO Auto-generated method stub
		for (Register register : registers) {
			if(register!=null && register.getId().equals(id))
				return register;
		}
		return null;
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		return registers;
	}

	@Override
	public String deleteUserById(String id) {
		// TODO Auto-generated method 
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

}
