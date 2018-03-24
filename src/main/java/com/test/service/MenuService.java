package com.test.service;

import com.test.common.Page;
import com.test.pojo.Menu;

public interface MenuService {
	public void add(Menu menu);
	public void delete(Integer id);
	public void update(Menu menu);
	/*public Menu select();*/
	public Page<Menu> select(Page<Menu> page);
	public Menu getById(Integer id);
	public Integer selectName(String name);

}
