package com.test.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.MenuDao;
import com.test.pojo.Menu;
import com.test.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDao menuDao;
	
	
	public void add(Menu menu) {
		menuDao.add(menu);
		
	}


	public void delete(Integer id) {
		menuDao.delete(id);
		
	}


	public void update(Menu menu) {
		menuDao.update(menu);
		
	}


	/*public Menu select() {
		Menu menu = menuDao.select();
		return menu;
	}*/

}
