package org.openhmis.webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.openhmis.dao.ConsentProfileDAO;
import org.openhmis.domain.ConsentProfile;
import org.openhmis.domain.PathClientRace;
import org.openhmis.domain.TmpUser;
import org.openhmis.dto.ClientDTO;
import org.openhmis.exception.AccessDeniedException;
import org.openhmis.dto.search.ClientSearchDTO;
import org.openhmis.manager.ClientManager;
import org.openhmis.util.Authentication;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/clients")
public class ClientService {
	private static final Logger log = Logger.getLogger(ClientService.class);
	private static final ClientManager clientManager = new ClientManager();

	public ClientService() {}
	
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ClientDTO> getClients(@HeaderParam("Authorization") String authorization, @BeanParam ClientSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
			throw new AccessDeniedException();

		// Return clients that match the search terms
        List<ClientDTO> clientDTOs = clientManager.getClients(searchDTO);
        
        // Filter out any values the user can't access
		TmpUser currentUser = Authentication.getCurrentUser(authorization);
		ConsentProfileDAO consentProfileDAO = new ConsentProfileDAO();
		ConsentProfile consentProfile = consentProfileDAO.getConsentProfile(
			Integer.parseInt(currentUser.getOrganization()),
			Integer.parseInt(currentUser.getCoC())
		);
		
		List<ClientDTO> cleanClientDTOs = new ArrayList<ClientDTO>();
		for (Iterator<ClientDTO> iterator = clientDTOs.iterator(); iterator.hasNext();) {
			ClientDTO clientDTO = iterator.next();
			clientDTO.processConsentProfile(consentProfile);
			cleanClientDTOs.add(clientDTO);
		}

        /* TBD (issue #65): We need to determine a standard logging
           format, some conventions, and maybe a helper class to
           enforce it all; would also be nice to log which user made
           the request.  But for now, just show that logging works. */
        log.info("GET /clients/ (" + cleanClientDTOs.size() + " results)");
        return cleanClientDTOs;
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ClientDTO createClient(@HeaderParam("Authorization") String authorization, ClientDTO inputVO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		ClientDTO outputVO = clientManager.addClient(inputVO);
        log.info("POST /clients/ (new id: " + outputVO.getId() + ")");
		return outputVO;
	}
	
	@GET
	@Path("/{personalId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ClientDTO getClient(@HeaderParam("Authorization") String authorization, @PathParam("personalId") String personalId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		ClientDTO clientDTO = clientManager.getClientByPersonalId(personalId);
		
		TmpUser currentUser = Authentication.getCurrentUser(authorization);
		
		ConsentProfileDAO consentProfileDAO = new ConsentProfileDAO();
		ConsentProfile consentProfile = consentProfileDAO.getConsentProfile(
			Integer.parseInt(currentUser.getOrganization()),
			Integer.parseInt(currentUser.getCoC())
		);
		clientDTO.processConsentProfile(consentProfile);
        log.info("GET /clients/" + personalId);
        return clientDTO;
	}
	
	@PUT
	@Path("/{personalId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ClientDTO updateClient(@HeaderParam("Authorization") String authorization, @PathParam("personalId") String personalId, ClientDTO inputVO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		inputVO.setPersonalId(personalId);
		
		ClientDTO outputVO = clientManager.updateClient(inputVO);
                log.info("PUT /clients/" + personalId);
		return outputVO;
	}
	
	@DELETE
	@Path("/{personalId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteClient(@HeaderParam("Authorization") String authorization, @PathParam("personalId") String personalId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		clientManager.deleteClient(personalId);
                log.info("DELETE /clients/" + personalId);
		return "true";
	}
}
