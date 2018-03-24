package com.test.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.common.Page;
import com.test.dao.MenuDao;
import com.test.pojo.Menu;
import com.test.pojo.UserInfo;

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


	@Override
	public Page<Menu> select(Page<Menu> page) {
		SqlSession session = sqlSessionFactory.openSession();
		Integer startNo = page.getStartNo();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNo", startNo);
		map.put("count", page.getPageSize());
		List<Menu> list = session.selectList("menumapper.select",map);
		page.setResult(list);
		page.setTotalSize(countAll());
		if(page.getTotalSize()%page.getPageSize()==0) {
			page.setTotalPage(page.getTotalSize()/page.getPageSize());
		}else {
			page.setTotalPage(page.getTotalSize()/page.getPageSize()+1);
		}
		session.close();
		return page;
	}
	public Integer countAll() {
		SqlSession session =sqlSessionFactory.openSession();
		Integer count =session.selectOne("menumapper.countAll");
		session.close();
		return count;
	}


	@Override
	public Menu getById(Integer id) {
		SqlSession session =sqlSessionFactory.openSession();
		Menu menu = session.selectOne("menumapper.selectOne",id);
		session.close();
		return menu;
	}


	@Override
	public Integer selectName(String name) {
		SqlSession session =sqlSessionFactory.openSession();
		Integer nameCount = session.selectOne("menumapper.selectNameCount",name);
		session.close();
		return nameCount;
	}


	/*public List<Menu> select() {
		
		SqlSession session = sqlSessionFactory.openSession();
		List<Menu> list = session.selectList("menumapper.select");
		session.close();
		return list;
	}
*/
}
