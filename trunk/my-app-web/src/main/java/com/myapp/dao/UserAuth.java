package com.myapp.dao;

import com.myapp.bean.UserLogin;

public interface UserAuth {
	public UserLogin fetchByUserName(String userName);
}
