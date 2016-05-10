



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
import org.openhmis.dto.InventoryDTO;
import org.openhmis.manager.InventoryManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/inventories")
public class InventoryService {
	private static final Logger log = Logger.getLogger(InventoryService.class);
	public InventoryService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<InventoryDTO> getInventories(@HeaderParam("Authorization") String authorization, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		
		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<InventoryDTO> inventoryDTOs = InventoryManager.getInventories();
			return inventoryDTOs;
		} else {
			List<InventoryDTO> inventoryDTOs = InventoryManager.getInventories(DateParser.parseDate(updatedSince));
			return inventoryDTOs;			
		}
		
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public InventoryDTO createInventory(@HeaderParam("Authorization") String authorization, InventoryDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		InventoryDTO outputDTO = InventoryManager.addInventory(inputDTO);
		return outputDTO;
	}
	
	@GET
	@Path("/{inventoryId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public InventoryDTO getInventory(@HeaderParam("Authorization") String authorization, @PathParam("inventoryId") String inventoryId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		InventoryDTO outputDTO = InventoryManager.getInventoryById(inventoryId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{inventoryId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public InventoryDTO updateInventory(@HeaderParam("Authorization") String authorization, @PathParam("inventoryId") String inventoryId, InventoryDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		inputDTO.setInventoryId(inventoryId);
		
		InventoryDTO outputDTO = InventoryManager.updateInventory(inputDTO);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{inventoryId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteInventory(@HeaderParam("Authorization") String authorization, @PathParam("inventoryId") String inventoryId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		InventoryManager.deleteInventory(inventoryId);
		return "true";
	}
}
