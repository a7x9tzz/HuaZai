package com.test.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.UserInfoDao;
import com.test.pojo.UserInfo;

@Repository("userInfoDao")
public class UserInfoDaoImpl implements UserInfoDao {
	
	@Autowired
	SqlSessionFactory sqlSessionFactory ;
	
	@Override
	public void add(UserInfo user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("userinfomapper.delete", id);
		session.close();
	}

	@Override
	public void update(UserInfo user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserInfo> search() {
		// TODO Auto-generated method stub
		return null;
	}

}
