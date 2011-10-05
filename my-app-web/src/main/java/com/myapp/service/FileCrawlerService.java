package com.myapp.service;

import java.io.File;

import com.myapp.bean.Files;

public interface FileCrawlerService {
	public void storeDir(File file);
	public void storeDir(File[] file);
	public String getOneFile();
	public void deleteOneFile(String path);
	public boolean deleteUnused(String path);
	public void indexFile(Files files);
}
