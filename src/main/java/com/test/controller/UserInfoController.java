package com.test.controller;

import java.util.List;

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
	
	@RequestMapping("/listView2")
	public ModelAndView listView2() {
		ModelAndView view = new ModelAndView("/userinfo/userinfoList2");
		List<UserInfo> list=userInfoService.select2();
		view.addObject("result", list);
		return view;
	}
	
	
	
	@RequestMapping("/addView")
	public ModelAndView addView() {
		ModelAndView view = new ModelAndView("/userinfo/add");
		return view;
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id) {
		//System.out.println(id);
		userInfoService.delete(id);
		return "redirect:/userInfo/listView";
		
	}
	@RequestMapping("/add")
	public String add(UserInfo  user) { // ʵ���������ֱ����Ϊ������ҩ��@RequestBody
		userInfoService.add(user);
		return "redirect:/userInfo/listView";
	}
	@RequestMapping("/updateView")
	public ModelAndView updateView(UserInfo user) {
		System.out.println(user);
		ModelAndView view = new ModelAndView("/userinfo/update");
		view.addObject("user",user);
		return view;
	}
	@RequestMapping("/update")
	public String update(@RequestBody UserInfo  user){
		
		userInfoService.update(user);
		return "redirect:/userInfo/listView";
	}
	
}
