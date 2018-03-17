package com.test.dao;

import com.test.pojo.Menu;

public interface MenuDao {
	
	public void add(Menu menu);
	
	public void delete(Integer id);
	
	public void update(Menu menu);
	
	public Menu select();

}
