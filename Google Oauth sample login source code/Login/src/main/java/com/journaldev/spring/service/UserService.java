package com.journaldev.spring.service;

import java.util.List;
import com.journaldev.spring.model.UserInfo;

public interface UserService {

	public List<UserInfo> LoginUser(String username,String password);
	
}
