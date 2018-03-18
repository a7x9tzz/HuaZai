package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.common.Page;
import com.test.pojo.UserInfo;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping(value="/aaa", method= {RequestMethod.GET,RequestMethod.POST}) // {name:'zs',age:11}
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/userinfo/userinfoList");
		
		Page<UserInfo> page = new Page<UserInfo>();
		List<UserInfo> list = new ArrayList<UserInfo>();
		UserInfo user = new UserInfo();
		user.setName("aaa");
		user.setId(1);
		user.setAddress("asdfjowjefow");
		user.setType(1);
		list.add(user);
		page.setTotalSize(10);
		page.setResult(list);
		page.setCurrentPage(3);
		page.setTotalPage(10);
		view.addObject("page", page);
		return view;
	}
}
