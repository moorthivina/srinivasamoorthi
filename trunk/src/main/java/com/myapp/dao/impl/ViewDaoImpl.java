package com.myapp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.bean.Files;
import com.myapp.bean.UserLogin;
import com.myapp.dao.ViewDao;

@Service
public class ViewDaoImpl implements ViewDao {

	private SessionFactory sesFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		sesFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Files> getFiles(int page, int size) {
		Session session = getSession();
		Query query = session.getNamedQuery(Files.LISTFILES);
		query.setFirstResult(page);
		query.setMaxResults(size);
		List<Files> list = query.list();
		System.out.println("Returned size - " + list.size());
		return list;
	}

	public void createLogin(UserLogin user) {
		Session session = getSession();
		session.saveOrUpdate(user);
	}
	
	private Session getSession() {
		return sesFactory.openSession();
	}
}
