package com.apap.tutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.apap.tutorial.model.UserRoleModel;
import com.apap.tutorial.repository.UserRoleDb;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDb userDb;
	
	@Override
	public UserRoleModel addUser(UserRoleModel user) {
		String pass = encrypt(user.getPassword());
		user.setPassword(pass);
		return userDb.save(user);
	}

	@Override
	public String encrypt(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		return hashedPassword;
	}

	@Override
	public void updatePassword(UserRoleModel user, String newPassword) {
		String pass = encrypt(newPassword);
		user.setPassword(pass);
		userDb.save(user);
		
	}

	@Override
	public UserRoleModel searchUserByUsername(String username) {
		return userDb.findByUsername(username);

	}

}
