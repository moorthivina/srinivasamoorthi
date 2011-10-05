package com.myapp.crawler.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import com.myapp.bean.Files;
import com.myapp.service.FileCrawlerService;

public class FileThread extends Thread {

	File file;
	String status;

	@Autowired
	private FileCrawlerService service;

	public FileThread(File file) {
		super(file.getPath());
		this.file = file;
		this.status="pending";
		System.gc();
	}
	
	public void findPath(File path, String dirPath){
		System.gc();
		if(!"c://windows".equalsIgnoreCase(dirPath) && !"C://Program Files".equalsIgnoreCase(dirPath)){
			try {
				if(path.list() != null){
					String fileArr[] = path.list();
					for(int i=0;i<fileArr.length;i++) {
						System.gc();
						File file;
						file = new File(dirPath +"/"+ fileArr[i]);
						addList(dirPath, fileArr[i]);
						if(file.isDirectory()) { 
							service.storeDir(file);
							if(!CrawlerImpl.th.isAlive()){
								CrawlerImpl.th = new ThreadHandler();
								CrawlerImpl.th.start();
							}
							System.out.println(this.getName() + " - file.getPath() " + file.getPath());
						}
					}
				}
			} catch(NullPointerException e){
				e.printStackTrace();
				return;
			}
		}
		this.status="complete";
		if(!CrawlerImpl.th.isAlive()){
			CrawlerImpl.th = new ThreadHandler();
			CrawlerImpl.th.start();
		}
		System.gc();
		return;
	}

	public void addList(String dirPath, String fileName) {
		Files fileList = new Files();
		fileList.setFileName(fileName);
		fileList.setFilePath(dirPath);
		service.indexFile(fileList);
	}
	
	public void run() {
		System.gc();
		String path = "";
		if(file.getParent()!=null && "".equals(file.getParent()))
			path = file.getParent();
		else
			path = file.getPath();

		addList(path.replace("\\", "/"), file.getName());
		findPath(file,file.getPath().replace("\\", "/"));
		service.deleteUnused(path.replace("\\", "/"));
		if(!CrawlerImpl.th.isAlive()){
			CrawlerImpl.th = new ThreadHandler();
			CrawlerImpl.th.start();
		}
	}

}
