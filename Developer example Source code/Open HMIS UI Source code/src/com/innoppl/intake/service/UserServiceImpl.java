package com.innoppl.intake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innoppl.intake.dao.UserDAO;
import com.innoppl.intake.model.UserInfo;

/*
 * @author  Haridharan Durairaj
 * 
 */
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
