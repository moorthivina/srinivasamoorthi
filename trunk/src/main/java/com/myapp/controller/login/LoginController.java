package com.myapp.controller.login;

import javax.security.auth.login.AppConfigurationEntry;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	private static final Log LOG = LogFactory.getLog(LoginController.class);

	@RequestMapping("/login/login.html")
	public String login(){
		LOG.debug("reached login ctrl");
		System.out.println("reached login ctrl");
		return "/login/login";
	}
	
	@RequestMapping("/login/loginsubmit.html")
	public ModelAndView loginSubmit(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("user") String user, @RequestParam("pass") String pass){
		LOG.debug("reached login sub ctrl");
		System.out.println("reached login sub ctrl");
		SecurityContext cont = SecurityContextHolder.getContext();
		Authentication auth = cont.getAuthentication();
		ModelAndView model = new ModelAndView("/homepage/home");
		return model;
	}
}
