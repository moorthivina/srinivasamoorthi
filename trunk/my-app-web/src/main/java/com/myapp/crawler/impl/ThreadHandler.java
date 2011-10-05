package com.myapp.crawler.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.myapp.dao.ViewDao;
import com.myapp.service.FileCrawlerService;

public class ThreadHandler extends Thread {
	private static List<FileThread> list = new ArrayList<FileThread>();

	@Autowired
	private FileCrawlerService service;
	
	public ThreadHandler() {
		super("master");
	}

	static final int MAX_THREAD = 75;

	public void run() {
		FileThread fileThread;
		String path;
		for(;;) {
			System.out.println("Thread.activeCount() - " + Thread.activeCount());
			path = service.getOneFile();
			if (path != null && Thread.activeCount() <= MAX_THREAD) {
				//service.deleteOneFile(path);
				fileThread = new FileThread(new File(path));
				fileThread.start();
				System.out.println(fileThread.getName());
				list.add(fileThread);
			}
		}
	}
}
