package com.myapp.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.providers.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.bean.Files;
import com.myapp.bean.UserLogin;
import com.myapp.service.ViewResultsService;

@Controller
public class ViewResults {

	private final static Logger LOG = Logger.getLogger(ViewResults.class.toString());
	
	@Autowired
	private ViewResultsService viewResultServiceImpl;

	@RequestMapping("/listfiles.html")
	public ModelMap login(){
		LOG.info("Reached controller");
		ModelMap map = new ModelMap();
		List<Files> list = viewResultServiceImpl.getList(1, 1000);
		map.addAttribute("list", list);
		// createLogin();
		return map;
	}
	
	private void createLogin(){
		Md5PasswordEncoder encode = new Md5PasswordEncoder();
		UserLogin user = new UserLogin();
		user.setLoginName("MOORTHI");
		user.setPassword(encode.encodePassword("password", null));
		viewResultServiceImpl.createLogin(user);
	}
}
