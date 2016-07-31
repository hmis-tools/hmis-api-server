



package org.openhmis.webservice;

import java.io.IOException;
import java.util.List;

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
import org.openhmis.dto.ContactDTO;
import org.openhmis.exception.AccessDeniedException;
import org.openhmis.manager.ContactManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/contacts")
public class ContactService {
	private static final Logger log = Logger.getLogger(ContactService.class);
	public ContactService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ContactDTO> getContacts(@HeaderParam("Authorization") String authorization, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();

                List<ContactDTO> contactDTOs;
		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			contactDTOs = ContactManager.getContacts();
		} else {
			contactDTOs = ContactManager.getContacts(DateParser.parseDate(updatedSince));
		}
                log.info("GET /contacts/ (" + contactDTOs.size() + " results)");
                return contactDTOs;
                        
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ContactDTO createContact(@HeaderParam("Authorization") String authorization, ContactDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		ContactDTO outputDTO = ContactManager.addContact(inputDTO);
                log.info("POST /contacts (new id: " + outputDTO.getId() + ")");
		return outputDTO;
	}
	
	@GET
	@Path("/{contactId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ContactDTO getContact(@HeaderParam("Authorization") String authorization, @PathParam("contactId") String contactId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		ContactDTO outputDTO = ContactManager.getContactById(contactId);
                /* TODO: In most similar logging lines, we use the
                   original variable (e.g., contactId) instead of
                   calling a getID() method on the resultant object.
                   Why is this case different? */
                log.info("GET /contacts/" + outputDTO.getId());
		return outputDTO;
	}
	
	@PUT
	@Path("/{contactId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ContactDTO updateContact(@HeaderParam("Authorization") String authorization, @PathParam("contactId") String contactId, ContactDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		inputDTO.setContactId(contactId);
		
		ContactDTO outputDTO = ContactManager.updateContact(inputDTO);
                log.info("PUT /contacts/" + contactId);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{contactId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteContact(@HeaderParam("Authorization") String authorization, @PathParam("contactId") String contactId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		ContactManager.deleteContact(contactId);
                log.info("DELETE /contacts/" + contactId);
		return "true";
	}
}
