package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.UserInfo;





public interface UserDAO {

	public List<UserInfo> LoginUser(String username,String password);
	
}
