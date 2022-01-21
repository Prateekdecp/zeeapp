package com.zee.zee5app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Register;

import exception.IdNotFoundException;

public interface UserRepository2 {
	public String addUser(Register register);
	public String updateUser(String id, Register register);
	public Optional<Register> getUserById(String id) throws IdNotFoundException;
	public Register[] getAllUsers();
	public List<Register> GetAllUser();
	public String deleteUserById(String id) throws IdNotFoundException;
}
