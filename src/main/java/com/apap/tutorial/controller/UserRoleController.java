package com.apap.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.apap.tutorial.model.UserRoleModel;
import com.apap.tutorial.service.UserRoleService;

@Controller
@RequestMapping("/user")
public class UserRoleController {
	@Autowired
	private UserRoleService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	private String addUserSubmit(@ModelAttribute UserRoleModel user) {
		userService.addUser(user);
		return "home";
	}
	
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	private String updatePassSubmit(@RequestParam("passLama") String passLama,
									@RequestParam("passBaru") String passBaru,
									@RequestParam("passUlang") String passUlang,
									@RequestParam("username") String username){
		UserRoleModel tempUser = userService.searchUserByUsername(username);

//		System.out.println(tempUser.getPassword());
//		System.out.println(webSecurityConfig.encoder().encode(passLama));
//		System.out.println();
		
		if (!passwordEncoder.matches(passLama, tempUser.getPassword())){
			return "tidakBenar";
		}
		else if(!passBaru.equals(passUlang)) {
			return "tidakBenar";
		}
		userService.updatePassword(tempUser, passBaru);
		return "home";
	}

}
