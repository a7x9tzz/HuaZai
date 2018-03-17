package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.service.UserInfoService;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping("/delete")
	public void delete(Integer id) {
		userInfoService.delete(id);
	}
	
}
