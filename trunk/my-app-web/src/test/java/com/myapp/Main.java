package com.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myapp.crawler.Crawler;
import com.myapp.crawler.impl.CrawlerImpl;

public class Main {

	@Autowired
	public Crawler c;

	public Main() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {
						"ApplicationContext-data.xml",
						"ApplicationContext-service.xml" });
		c = new CrawlerImpl();
	}

	public static void main(String[] args) {
		new Main().c.startCrawl();
	}

	private Crawler getC() {
		return c;
	}
}
