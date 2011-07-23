package com.myapp.service;

import java.util.List;

import com.myapp.bean.Files;
import com.myapp.bean.UserLogin;

public interface ViewResultsService {
	public List<Files> getList(int pageNo, int size);
	public void createLogin(UserLogin user);
}
