package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository2;

public class UserRepositoryImpl implements UserRepository2 {
	private ArrayList<Register> registers=new ArrayList<Register>();
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
		boolean res=this.registers.add(register);
		return res?"success":"failure";
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
	public Optional<Register> getUserById(String id) {
		// TODO Auto-generated method stub
		for (Register register : registers) {
			if(register!=null && register.getId().equals(id))
				return Optional.of(register);
		}
		return Optional.empty();
	}

	@Override
	public ArrayList<Register> getAllUsers() {
		// TODO Auto-generated method stub
		return registers;
	}

	@Override
	public String deleteUserById(String id) {
		// TODO Auto-generated method 
		int index=-1;
		for(int i=0;i<registers.size();i++)
		{
			if(registers.get(i).getId().equals(id))
			{
				index=i;
				break;
			}
		}
		if(index!=-1)
			registers.remove(index);
		return index==-1?"not found":"deleted successfully";
	}

}
