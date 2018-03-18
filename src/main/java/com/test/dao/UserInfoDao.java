package com.test.dao;


import com.test.common.Page;
import com.test.pojo.UserInfo;

public interface UserInfoDao {
	public void add(UserInfo user);
	
	public void delete(Integer id);
	
	public void update(UserInfo user);
	
	public Page<UserInfo> select(Page<UserInfo> page);
	
	public Integer countAll();
	
}
