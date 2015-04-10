package com.innoppl.intake.service;

import java.util.List;

import com.innoppl.intake.model.UserInfo;

/*
 * @author  Haridharan Durairaj
 * 
 */
public interface UserService {

	public List<UserInfo> LoginUser(String username,String password);
	
}
