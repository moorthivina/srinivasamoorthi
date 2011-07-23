package com.myapp.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index.html")
public class Index {
	private static final Logger LOG = Logger.getLogger(Index.class.toString());
	
	@RequestMapping(method=RequestMethod.GET)
	public String indexMap(HttpServletRequest request, HttpServletResponse response){
		LOG.info("index reached");
		return "index";
	}
}