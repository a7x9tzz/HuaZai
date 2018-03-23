package com.test.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.common.Page;
import com.test.dao.UserInfoDao;
import com.test.pojo.UserInfo;

@Repository("userInfoDao")

public class UserInfoDaoImpl implements UserInfoDao {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory ;
	
	public void add(UserInfo user) {
		
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("userinfomapper.add",user);
		session.close();
		
	}

	public void delete(Integer id) {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("userinfomapper.delete", id);
		session.close();
	}
	@Override
	public void update(UserInfo user) {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("userinfomapper.update",user);
		session.close();

	}

	public Page<UserInfo> select(Page<UserInfo> page) {
		SqlSession session = sqlSessionFactory.openSession();
		Integer startNo = page.getStartNo();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNo", startNo);
		map.put("count", page.getPageSize());
		List<UserInfo> list = session.selectList("userinfomapper.select",map);
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

	@Override
	public Integer countAll() {
		SqlSession session = sqlSessionFactory.openSession();
		Integer count = session.selectOne("userinfomapper.countAll");
		session.close();
		return count;
	}

	@Override
	public List<UserInfo> select2() {
		SqlSession session = sqlSessionFactory.openSession();
		List<UserInfo> list = session.selectList("userinfomapper.select2");
		session.close();
		return list;
	}

	@Override
	public UserInfo getById(Integer id) {
		SqlSession session = sqlSessionFactory.openSession();
		UserInfo user =session.selectOne("userinfomapper.selectOne",id);
		
		session.close();
		return user;
	}


}
