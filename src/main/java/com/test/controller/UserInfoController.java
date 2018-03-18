package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.common.Page;
import com.test.pojo.UserInfo;
import com.test.service.UserInfoService;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping("/listView")
	public ModelAndView listView(Page<UserInfo> page) {
		if(null == page.getCurrentPage()) {
			page.setCurrentPage(1);
		}
		ModelAndView view = new ModelAndView("/userinfo/userinfoList");
		userInfoService.select(page);
		view.addObject("page", page);
		return view;
	}
	
	@RequestMapping("/addView")
	public ModelAndView addView() {
		ModelAndView view = new ModelAndView("/userinfo/add");
		
		return view;
	}
	
	@RequestMapping("/delete")
	public void delete(Integer id) {
		userInfoService.delete(id);
	}
	@RequestMapping("/add")
	public String add(UserInfo  user) { // ʵ���������ֱ����Ϊ������ҩ��@RequestBody
		userInfoService.add(user);
		return "redirect:/userInfo/listView";
	}
	@RequestMapping("/update")
	public void update(@RequestBody UserInfo  user){
		userInfoService.update(user);
	}
	
}
