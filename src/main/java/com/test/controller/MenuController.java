package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.pojo.Menu;
import com.test.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/add")
	public void add(@RequestBody Menu menu) {
		
		menuService.add(menu);
	}
	
	@RequestMapping("/delete")
	public void delete(Integer id) {
		
		menuService.delete(id);
		
	}
	
	@RequestMapping("/update")
	public void update(@RequestBody Menu menu) {
		
		menuService.update(menu);
		
	}
	
	@RequestMapping("/select")
	public Menu select() {
		
		Menu menu = menuService.select();
		return menu;
	}

}
