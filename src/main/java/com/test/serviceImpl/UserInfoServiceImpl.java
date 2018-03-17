package com.test.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.UserInfoDao;
import com.test.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;
	
	@Override
	public void delete(Integer id) {
		userInfoDao.delete(id);
	}

}
