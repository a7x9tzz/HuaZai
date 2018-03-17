package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.pojo.UserInfo;
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
	@RequestMapping("/add")
	public void add(@RequestBody UserInfo  user) { // 实体类对象不能直接作为参数，药价@RequestBody
		userInfoService.add(user);
	}
	@RequestMapping("/update")
	public void update(@RequestBody UserInfo  user){
		userInfoService.update(user);
	}
	@RequestMapping("/select")
	public UserInfo select() {
		UserInfo user = userInfoService.select();
		return user;
	}
	
}
