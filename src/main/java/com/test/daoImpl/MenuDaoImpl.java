package com.test.daoImpl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.MenuDao;
import com.test.pojo.Menu;

@Repository("menuDao")
public class MenuDaoImpl implements MenuDao {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory ;
	
	
	public void add(Menu menu) {
		
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("menumapper.add",menu);
		session.close();
	}


	public void delete(Integer id) {
		
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("menumapper.delete",id);
		session.close();
		
	}


	public void update(Menu menu) {
		
		SqlSession session = sqlSessionFactory.openSession();
		session.update("menumapper.update",menu);
		session.close();
		
	}


	public Menu select() {
		
		SqlSession session = sqlSessionFactory.openSession();
		Menu menu = (Menu)session.selectList("menumapper.select");
		session.close();
		return menu;
	}

}
