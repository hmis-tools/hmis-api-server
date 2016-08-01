



package org.openhmis.webservice;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.openhmis.dto.UserDTO;
import org.openhmis.dto.search.UserSearchDTO;
import org.openhmis.exception.AccessDeniedException;
import org.openhmis.manager.UserManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/users")
public class UserService {
	private static final Logger log = Logger.getLogger(ExitService.class);
	public UserService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<UserDTO> getUsers(@HeaderParam("Authorization") String authorization, @BeanParam UserSearchDTO searchDTO ) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.ADMIN))
                        throw new AccessDeniedException();
		List<UserDTO> userDTOs = UserManager.getUsers(searchDTO);
                log.info("GET /users (" + userDTOs.size() + " results)");
		return userDTOs;
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public UserDTO createUser(@HeaderParam("Authorization") String authorization, UserDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.ADMIN))
                        throw new AccessDeniedException();
		UserDTO outputDTO = UserManager.addUser(inputDTO);
                log.info("POST /users (new id: " + outputDTO.getId() + ")");
		return outputDTO;
	}
	
	@GET
	@Path("/{userId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public UserDTO getUser(@HeaderParam("Authorization") String authorization, @PathParam("userId") String userId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.ADMIN))
                        throw new AccessDeniedException();
		UserDTO outputDTO = UserManager.getUserById(userId);
                log.info("GET /users/" + userId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{userId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public UserDTO updateUser(@HeaderParam("Authorization") String authorization, @PathParam("userId") String userId, UserDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.ADMIN))
                        throw new AccessDeniedException();
		inputDTO.setUserId(userId);
		
		UserDTO outputDTO = UserManager.updateUser(inputDTO);
                log.info("PUT /users/" + userId);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{userId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteUser(@HeaderParam("Authorization") String authorization, @PathParam("userId") String userId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.ADMIN))
                        throw new AccessDeniedException();
		UserManager.deleteUser(userId);
                log.info("DELETE /users/" + userId);
		return "true";
	}
}
