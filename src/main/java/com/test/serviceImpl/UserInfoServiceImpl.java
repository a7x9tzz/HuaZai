package com.test.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.common.Page;
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



	@Override
	public Page<UserInfo> select(Page<UserInfo> page) {
		return userInfoDao.select(page);
	}



	@Override
	public List<UserInfo> select2() {
		// TODO Auto-generated method stub
		return userInfoDao.select2();
	}



	@Override
	public UserInfo getById(Integer id) {
		return userInfoDao.getById(id);
		
	}



}
