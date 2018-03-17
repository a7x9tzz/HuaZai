package com.test.daoImpl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	public void update(UserInfo user) {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("userinfomapper.update",user);
		session.close();

	}

	public UserInfo select() {
		SqlSession session = sqlSessionFactory.openSession();
		UserInfo user = (UserInfo)session.selectList("userinfomapper.select");
		session.close();
		return user;
	}


}
