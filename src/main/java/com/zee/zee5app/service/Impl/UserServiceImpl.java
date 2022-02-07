package com.zee.zee5app.service.Impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	LoginService loginService;

	public UserServiceImpl() throws IOException {

	}
	
	@Override
	@org.springframework.transaction.annotation.Transactional(rollbackFor = AlreadyExistsException.class)
	public Register addUser(Register register) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		if(repository.existsByEmailAndContactnumber(register.getEmail(), register.getContactnumber()) == true) {
			throw new AlreadyExistsException("this record already exists");
			//NullPointerException("!!! null pointer exists !!!");
		}
		Register register2 = repository.save(register);
		if (register2 != null) {
//			Login login = new Login(register.getEmail(), register.getPassword(), register.getRegid());
//			String result = loginService.addCredentials(login);
//			if(result.equals( "success")) {
//				return "record is sucessfully added to register as well as login";
//			}
//			else {
//				return "fail";
//			}
			return register2;
		}
		else {
			return null;
		}
	}


	

	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Register getUserById(String id) throws IdNotFoundException{
		// TODO Auto-generated method stub
		Optional<Register> optional=this.repository.findById(id);
		if(optional.isEmpty())
			throw new IdNotFoundException("id does not exist");
		else
			return optional.get();
	}

	@Override
	public Register[] getAllUsers()
			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		List<Register> list = this.repository.findAll();
		Register array[] = new Register[list.size()];
		return list.toArray(array);
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Register optional = getUserById(id);
			if (optional==null) {
				throw new IdNotFoundException("record not found");
			} else {
				this.repository.deleteById(id);
				return "successfully deleted record";
			}
		} catch (IdNotFoundException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<List<Register>> getAllUserDetails()
	{
		// TODO Auto-generated method stub
		return Optional.ofNullable(this.repository.findAll());
	}

}
