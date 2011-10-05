package com.myapp.crawler.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.myapp.bean.Files;
import com.myapp.crawler.Crawler;
import com.myapp.service.FileCrawlerService;

@Service("fileCrawler")
@RemotingDestination(channels={"my-amf"})
public class CrawlerImpl implements Crawler {

	public static ThreadHandler th;

	@Autowired
	private FileCrawlerService service;

	public void startCrawl() {
		Files files = new Files();
		files.setFileName("fileName");
		files.setFilePath("filePath");
		service.indexFile(files);
		/*th = new ThreadHandler();
		th.start();*/
	}

	public void stopCrawl() {
		// TODO Auto-generated method stub
		
	}

	public void startNewCrawl() {
		File[] file = File.listRoots();
		for(int i = file.length-1; i>= 0; i--){
			System.out.println(file[i]);
			service.storeDir(file[i]);
		}
		th = new ThreadHandler();
		th.start();
	}

	public void addList(String dirPath, String fileName) {
		Files fileList = new Files();
		fileList.setFileName(fileName);
		fileList.setFilePath(dirPath);
		service.indexFile(fileList);
	}
}
