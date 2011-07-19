package com.myapp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.bean.UserLogin;
import com.myapp.dao.UserAuth;

@Service
public class UserAuthImpl implements UserAuth {

	private SessionFactory sesFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		sesFactory = sessionFactory;
	}

	public UserLogin fetchByUserName(String userName) {
		Session session = getSession();
		UserLogin dbUser = null;
        System.out.println("Checking if this is invoked - 2");
        String SQL_QUERY ="Select user from UserLogin user";

        Query query = session.createQuery(SQL_QUERY);
        System.out.println("Checking if this is invoked - 3");
        @SuppressWarnings("unchecked")
		List<UserLogin> l = query.list(); 
        System.out.println("Checking if this is invoked - 4" + l);
        for(UserLogin u:l) {
        	System.out.println("Checking if this is invoked - 5");
        	dbUser = u;
        	System.out.println(u.getPassword());
        }
        session.close();
		
		return dbUser;
	}

	private Session getSession() {
		System.out.println("At get session meth sessfact" + sesFactory);
		return sesFactory.openSession();
	}
}
