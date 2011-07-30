package com.myapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.myapp.bean.Files;
import com.myapp.bean.UserLogin;
import com.myapp.dao.ViewDao;
import com.myapp.service.ViewResultsService;

@Service("viewResultService")
@RemotingDestination(channels={"my-amf"})
public class ViewResultServiceImpl implements ViewResultsService {
	@Autowired
	private ViewDao dao;

	public List<Files> getList(int pageNo, int size){
		System.out.println("am at serv layer getList meth ");
		return dao.getFiles((pageNo-1)*size, size);
	}

	public void createLogin(UserLogin user){
		dao.createLogin(user);
	}
}
