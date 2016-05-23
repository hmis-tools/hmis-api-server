package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.dao.TmpUserDAO;
import org.openhmis.domain.TmpUser;
import org.openhmis.dto.UserDTO;
import org.openhmis.dto.search.UserSearchDTO;

public class UserManager {
	private static final TmpUserDAO tmpUserDAO = new TmpUserDAO();

	public UserManager() {}

	public static UserDTO getUserById(String userId) {
		UserDTO userDTO = UserManager.generateUserDTO(tmpUserDAO.getTmpUserById(Integer.parseInt(userId)));
		return userDTO;
	}

	public static List<UserDTO> getUsers(UserSearchDTO searchDTO) {
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();

		// Collect the users
		List<TmpUser> tmpUsers = tmpUserDAO.getTmpUsers(searchDTO);

		// For each TmpUser, collect and map the data
		for (Iterator<TmpUser> iterator = tmpUsers.iterator(); iterator.hasNext();) {
			TmpUser tmpUser = iterator.next();
			UserDTO userDTO = UserManager.generateUserDTO(tmpUser);
			userDTOs.add(userDTO);
		}
		return userDTOs;
	}

	public static UserDTO getUserByExternalId(String externalId) {
		
		// Collect the users
		TmpUser tmpUser = tmpUserDAO.getTmpUserByExternalId(externalId);

		UserDTO userDTO = UserManager.generateUserDTO(tmpUser);
		return userDTO;

	}
	
	public static UserDTO addUser(UserDTO inputDTO) {
		// Generate a TmpUser from the input
		TmpUser tmpUser = UserManager.generateTmpUser(inputDTO);
		
		// Set Export fields (TBD: is Export right here?)
		tmpUser.setDateCreated(new Date());
		tmpUser.setDateUpdated(new Date());
		
		// Save the user to allow secondary object generation
		tmpUserDAO.save(tmpUser);
		inputDTO.setUserId(tmpUser.getUserId().toString());
		
		// Return the resulting DTO
		return UserManager.generateUserDTO(tmpUser);
	}
	
	public static UserDTO updateUser(UserDTO inputDTO) {
		// Generate a user from the input
		TmpUser tmpUser = UserManager.generateTmpUser(inputDTO);
		tmpUser.setUserId(Integer.parseInt(inputDTO.getUserId()));
		tmpUser.setDateUpdated(new Date());
		
		// Update the object
		tmpUserDAO.update(tmpUser);
		
		// Return the resulting DTO
		return UserManager.generateUserDTO(tmpUser);

	}
	
	public static boolean deleteUser(String userId) {
		TmpUser tmpUser = tmpUserDAO.getTmpUserById(Integer.parseInt(userId));
		tmpUserDAO.delete(tmpUser);
		return true;
	}
	
	public static UserDTO generateUserDTO(TmpUser tmpUser) {
		UserDTO userDTO = new UserDTO();

		userDTO.setUserId(tmpUser.getUserId().toString());
		userDTO.setExternalId(tmpUser.getExternalId());
		userDTO.setCanRead(tmpUser.getCanRead());
		userDTO.setCanWrite(tmpUser.getCanWrite());
		userDTO.setCanAdmin(tmpUser.getCanAdmin());
		
		// Export Standard Fields (TBD: what are "Standard Fields"?)
		userDTO.setDateCreated(tmpUser.getDateCreated());
		userDTO.setDateUpdated(tmpUser.getDateUpdated());
		
		return userDTO;
	}
	
	public static TmpUser generateTmpUser(UserDTO inputDTO) {
		TmpUser tmpUser = new TmpUser();
		
		tmpUser.setExternalId(inputDTO.getExternalId());
		tmpUser.setCanRead(inputDTO.getCanRead());
		tmpUser.setCanWrite(inputDTO.getCanWrite());
		tmpUser.setCanAdmin(inputDTO.getCanAdmin());
		
		// Export Standard Fields (TBD: what are "Standard Fields"?)
		tmpUser.setDateCreated(inputDTO.getDateCreated());
		tmpUser.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpUser;
	}
	
}
