package com.test.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.common.Page;
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


	@Override
	public Page<Menu> select(Page<Menu> page) {
		Page<Menu> pageBean =menuDao.select(page);
		return pageBean;
	}


	@Override
	public Menu getById(Integer id) {
		
		return menuDao.getById(id);
	}


	@Override
	public Integer selectName(String name) {
		
		return menuDao.selectName(name);
	}


	/*public Menu select() {
		Menu menu = menuDao.select();
		return menu;
	}*/

}
