package com.innoppl.intake.dao;

import java.util.List;

import com.innoppl.intake.model.UserInfo;

/*
 * @author  Haridharan Durairaj
 * 
 */
public interface UserDAO {

	public List<UserInfo> LoginUser(String username,String password);
	
}
