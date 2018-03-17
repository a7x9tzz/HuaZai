package com.test.dao;

import java.util.List;

import com.test.pojo.UserInfo;

public interface UserInfoDao {
	public void add(UserInfo user);
	
	public void delete(Integer id);
	
	public void update(UserInfo user);
	
	public List<UserInfo> search();
}
