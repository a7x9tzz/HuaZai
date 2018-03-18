package com.test.service;

import com.test.pojo.UserInfo;

public interface UserInfoService {
	public void delete(Integer id);
	public void add(UserInfo user);
}
