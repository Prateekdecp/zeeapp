package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository2;

import exception.IdNotFoundException;

public class UserRepositoryImpl implements UserRepository2 {
	private HashSet<Register> registers=new LinkedHashSet<>();
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
	public Optional<Register> getUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Register register2=null;
		for (Register register : registers) {
			if(register.getId().equals(id))
			{
				register2=register;
				break;
			}
		}
		return Optional.of(Optional.ofNullable(register2).
				orElseThrow(()->new IdNotFoundException("id was not found")));
	}
//	@Override
//	public Register getUserById(String id) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		Register register2=null;
//		for (Register register : registers) {
//			if(register!=null && register.getId().equals(id))
//				register2=register;
//		}
//		if(register2==null)
//			throw new IdNotFoundException("id not found");
//		return register2;
//	}


	
	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		Register[] result=new Register[registers.size()];
		return registers.toArray(result);
	}
	
	@Override
	public List<Register> GetAllUser() {
		// TODO Auto-generated method stub
		
//		List<Register> list=new ArrayList(registers);
//		Collections.sort(list);
		return new ArrayList<>(registers);
	}
	
	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method 
		Optional<Register> optional=this.getUserById(id);
		if(optional.isPresent())
		{
			boolean result=registers.remove(optional.get());
			if(result)
				return "success";
			else
				return "fail";
		}
		throw new IdNotFoundException("id not found");
	}


}
