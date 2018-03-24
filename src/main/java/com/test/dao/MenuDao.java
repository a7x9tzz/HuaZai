package com.test.dao;

import com.test.common.Page;
import com.test.pojo.Menu;

public interface MenuDao {
	
	public void add(Menu menu);
	
	public void delete(Integer id);
	
	public void update(Menu menu);

	public Page<Menu> select(Page<Menu> page);

	public Menu getById(Integer id);

	public Integer selectName(String name);
	
	/*public Menu select();*/

}
