package org.openhims.oauth2.service;

import java.util.List;

import org.openhims.oauth2.domain.UsersHistory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsersHistoryService 
{
	public List<UsersHistory> getUsersHistoryByEmail(String email) throws UsernameNotFoundException;
}
