package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.common.Page;
import com.test.pojo.Menu;
import com.test.pojo.UserInfo;
import com.test.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	/**
	 * ajax 测试接口
	 * @param age
	 * @param str
	 * @return  0：不存在； 1：存在 /  “not exist”;"exist"
	 */
	/*@RequestMapping("/test")
	public @ResponseBody String test(@RequestParam(value="ageStand")Integer age, @RequestParam(value="xxx")String str) {
		System.out.println("=====================前段值： "+age);
		System.out.println("=====================前段值字符串： "+str);
		return "abcdefg";
	}*/
	@RequestMapping("/test")
	public @ResponseBody String test(@RequestBody UserInfo user) {
		System.out.println("=====================id： "+user.getId());
		System.out.println("=====================name： "+user.getName());
		System.out.println("=====================age： "+user.getAge());
		return "abcdefg";
	}
	@RequestMapping("/conflict")
	public @ResponseBody Integer conflict(@RequestParam(value="name")String name) {
		//System.out.println(menu);
		//System.out.println(menu.getName());
		Integer result = menuService.selectName(name);
		System.out.println(result);
		return result;
	}
	
	@RequestMapping("/listMenu")
	public ModelAndView listMenu(Page<Menu> page) {
		if(page.getCurrentPage()==null) {
			page.setCurrentPage(1);
		}
		ModelAndView view =new ModelAndView("/menu/menuList");
		menuService.select(page);
		view.addObject("page", page);
		return view;
	}
	@RequestMapping("/addView")
	public ModelAndView addView() {
		ModelAndView view = new ModelAndView("/menu/add");
		return view;
	}
	
	@RequestMapping("/add")
	public String add(/*@RequestBody*/ Menu menu) {
		
		menuService.add(menu);
		return "redirect:/menu/listMenu";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id) {
		
		menuService.delete(id);
		return "redirect:/menu/listMenu";
		
	}
	@RequestMapping("/updateView")
	public ModelAndView updateView(Integer id) {
		Menu menu = menuService.getById(id);
		ModelAndView view = new ModelAndView("/menu/update");
		view.addObject("menu", menu);
		return view;
	}
	
	@RequestMapping("/update")
	public String update(Menu menu) {
		
		menuService.update(menu);
		return "redirect:/menu/listMenu";
		
	}
	
	/*@RequestMapping("/select")
	public Menu select() {
		
		Menu menu = menuService.select();
		return menu;
	}*/

}
