package com.journaldev.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.journaldev.spring.dao.UserDAO;
import com.journaldev.spring.model.UserInfo;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public List<UserInfo> LoginUser(String username, String password) {
		return this.userDAO.LoginUser(username, password);
	}

}
