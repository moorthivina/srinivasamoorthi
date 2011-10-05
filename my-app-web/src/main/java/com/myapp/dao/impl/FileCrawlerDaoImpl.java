package com.myapp.dao.impl;

import java.io.File;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.bean.Files;
import com.myapp.bean.UpdateList;
import com.myapp.dao.FileCrawlerDao;

@Service
public class FileCrawlerDaoImpl implements FileCrawlerDao {

	private SessionFactory sesFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		sesFactory = sessionFactory;
	}

	@Transactional
	public void storeDir(File file) {
		Session session = getSession();
		UpdateList ul = new UpdateList();
		ul.setPath(file.getPath());
		ul.setStatus(1);
		session.saveOrUpdate(ul);
	}

	@Transactional
	public void storeDir(String query) {
		Query q = getSession().createSQLQuery(query);
		q.executeUpdate();
	}

	public String getOneFile() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteOneFile(String path) {
		// TODO Auto-generated method stub
		
	}

	private Session getSession() {
		return sesFactory.openSession();
	}

	public void indexFile(Files files) {
		getSession().merge(files);
		
	}
}
