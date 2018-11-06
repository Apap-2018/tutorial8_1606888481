package com.apap.tutorial.service;

import com.apap.tutorial.model.UserRoleModel;

public interface UserRoleService {
	UserRoleModel addUser(UserRoleModel user);
	String encrypt(String password);
	void updatePassword(UserRoleModel user, String newPassword);
	UserRoleModel searchUserByUsername(String username);

}
