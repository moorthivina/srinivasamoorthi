package com.myapp.dao;

import java.util.List;

import com.myapp.bean.Files;
import com.myapp.bean.UserLogin;

public interface ViewDao {
	public List<Files> getFiles(int page, int size);
	public void createLogin(UserLogin user);
}
