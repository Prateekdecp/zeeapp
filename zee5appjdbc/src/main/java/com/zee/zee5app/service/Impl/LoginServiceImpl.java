package com.zee.zee5app.service.Impl;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.repository.Impl.LoginRepositoryImpl;
import com.zee.zee5app.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	private static LoginService loginService = null;

	private static LoginRepositoryImpl loginRepository = null;

	public LoginServiceImpl() throws IOException {
//		loginRepository = LoginRepositoryImpl.getInstance();
	}



	@Override
	public String addCredentials(Login login) {
		return this.loginRepository.addCredentials(login);
	}

	@Override
	public String deleteCredentials(String userName) {
		return this.loginRepository.deleteCredentials(userName);
	}

	@Override
	public String changePassword(String userName, String password) {
		return this.loginRepository.changePassword(userName, password);
	}

	@Override
	public String changeRole(String username, ROLE role) {
		// TODO Auto-generated method stub
		return this.loginRepository.changeRole(username, role);
	}

}
