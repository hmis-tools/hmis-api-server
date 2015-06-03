package org.openhims.oauth2.service;

import org.openhims.oauth2.domain.Users;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsersService 
{
	public Users getUsersById(Long userId) throws UsernameNotFoundException;
	public Users getUserByName(String username) throws UsernameNotFoundException;
	public Users getUserByEmail(String email) throws UsernameNotFoundException;
}
