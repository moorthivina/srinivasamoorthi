package com.myapp.service.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.bean.Files;
import com.myapp.dao.FileCrawlerDao;
import com.myapp.service.FileCrawlerService;

@Service
public class FileCrawlerServiceImpl implements FileCrawlerService {

	@Autowired
	private FileCrawlerDao dao;

	public void storeDir(File file) {
		// TODO Auto-generated method stub
		
	}

	public String getOneFile() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteOneFile(String path) {
		// TODO Auto-generated method stub
		
	}

	public void storeDir(File[] file) {
		dao.storeDir(createTempQuery(file));
	}

	private String createTempQuery(File[] files){
		StringBuffer sb = new StringBuffer("");
		for(File f:files){
			sb.append("insert into UpdateList(path, status) values ('");
			sb.append(f.getPath()+"',1) ");
		}
		return sb.toString();
	}

	public boolean deleteUnused(String path) {
		// TODO Auto-generated method stub
		return false;
	}

	public void indexFile(Files files) {
		dao.indexFile(files);		
	}
}
