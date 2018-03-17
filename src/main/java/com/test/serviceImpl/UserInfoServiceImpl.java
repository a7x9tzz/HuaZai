package com.test.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.UserInfoDao;
import com.test.pojo.UserInfo;
import com.test.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;
	
	

	public void add(UserInfo user) {
		userInfoDao.add(user);
	}



	public void delete(Integer id) {
		userInfoDao.delete(id);
		
	}



	public void update(UserInfo user) {
		userInfoDao.update(user);
		
	}



	public UserInfo select() {
		UserInfo user = userInfoDao.select();
		return user;
	}

}
