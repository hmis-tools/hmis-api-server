package org.openhmis.generator;

public class UserGenerator {

	public UserGenerator() {
	}
	
	public UserDTO generateUserDTO(TmpUser tmpUser) {
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
	
	public TmpUser generateTmpUser(UserDTO inputDTO) {
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