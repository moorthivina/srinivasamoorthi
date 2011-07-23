package com.myapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.User;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.bean.UserLogin;
import com.myapp.dao.UserAuth;

@Service
public class CustumAuthDao implements UserDetailsService {

	@Autowired
	UserAuth dao;

	@Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        System.out.println("Checking if this is invoked - 1 " + dao);
        UserDetails user = null;
        UserLogin dbUser = dao.fetchByUserName(username);
        System.out.println("returned from dao " + dbUser);
		user = new User(dbUser.getLoginName(), dbUser.getPassword(), true, true, true, true, getAuthorities(new Integer(1)));
        return user;
    }

    private GrantedAuthority[] getAuthorities(Integer access) {
    	System.out.println("getAuthorities(");
        GrantedAuthority[] authList = new GrantedAuthority[2];

        authList[0] = new GrantedAuthorityImpl("ROLE_USER");
        if (access.compareTo(1) == 0) {
            authList[1] = new GrantedAuthorityImpl(("ROLE_ADMIN"));

        }
        return authList;
    }

	
	public UserAuth getDao() {
		return dao;
	}

	public void setDao(UserAuth dao) {
		this.dao = dao;
	}

}
