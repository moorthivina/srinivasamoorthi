package com.myapp.dao;

import java.io.File;

import com.myapp.bean.Files;

public interface FileCrawlerDao {
	public void storeDir(File file);
	public void storeDir(String query);
	public String getOneFile();
	public void deleteOneFile(String path);
	public void indexFile(Files files);
}
