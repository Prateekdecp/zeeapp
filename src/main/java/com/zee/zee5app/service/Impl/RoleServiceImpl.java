package com.zee.zee5app.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Role;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.service.RoleService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	@Override
	@Transactional(rollbackFor = Exception.class)
	public String addRole(Role role) {
		// TODO Auto-generated method stub
		Role role2=roleRepository.save(role);
		return role2!=null?"success":"fail";
	}

	@Override
	public void deleteRole(int roleId) {
		
		// TODO Auto-generated method stub
		Optional<Role> optional=roleRepository.findById(roleId);
		if(optional.isEmpty())
			System.out.println("Role is not present unable to delete");
		else
		{
			roleRepository.deleteById(roleId);
			System.out.println("successfully deleted role");
		}
	}

}
