package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.common.Page;
import com.test.pojo.Menu;
import com.test.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
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
