package com.apap.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial.model.UserRoleModel;
import com.apap.tutorial.service.UserRoleService;


@Controller
@RequestMapping("/user")
public class UserRoleController {
	@Autowired
	private UserRoleService userService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	private String addUserSubmit(@ModelAttribute UserRoleModel user) {
		userService.addUser(user);
		return "home";
	}
	
//	@RequestMapping(value = "/updatePass", method = RequestMethod.POST)
//	private String updatePassSubmit(@RequestParam("passLama") String passLama,
//									@RequestParam("passBaru") String passBaru,
//									@RequestParam("passUlang") String passUlang){
//		userService.updatePassword(user, newPassword);
//		return "home";
//	}

}
