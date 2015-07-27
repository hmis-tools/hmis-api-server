package org.openhmis.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.openhmis.code.ClientNameDataQuality;
import org.openhmis.manager.ClientManager;
import org.openhmis.vo.ClientVO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Path("/clients")
public class ClientService {
	private static final Logger log = Logger.getLogger(ClientService.class);
	private static final ObjectMapper om = new ObjectMapper();
	private static final ClientManager clientManager = new ClientManager();

//	private ClientManager clientManager;
//	Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
	public ClientService() {
	}
//
//
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON})
	public String getClients() throws JsonProcessingException {
		List<ClientVO> clientVOs = clientManager.getClients();
		return om.writeValueAsString(clientVOs);
	}
	
	@GET
	@Path("/{personalId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getClient(@PathParam("personalId") String personalId) throws JsonProcessingException {
		ClientVO clientVO = clientManager.getClientByPersonalId(personalId);
		return om.writeValueAsString(clientVO);
	}
//
//	@POST
//	@Path("/clients")
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//	public ClientVO getClient() throws ClientNotFoundException {
//		ClientVO clientVO = new ClientVO();
//		return clientVO;
//	}
//
//	@PUT
//	@Path("/clients")
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//	public ClientVO getClient() throws ClientNotFoundException {
//		ClientVO clientVO = new ClientVO();
//		return clientVO;
//	}
//
//	@DELETE
//	@Path("/clients")
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//	public ClientVO getClient() throws ClientNotFoundException {
//		ClientVO clientVO = new ClientVO();
//		return clientVO;
//	}
//
//
//	@GET
//	@Path("/clients/{clientId}")
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//	public ClientVO getClient(@PathParam("clientId") Long clientKey) throws ClientNotFoundException {
//		ClientVO clientVO = new ClientVO();
//		return clientVO;
//	}
//
//	@POST
//	@Path("/clients/{clientId}")
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//	public ClientVO getClient(@PathParam("clientId") Long clientKey) throws ClientNotFoundException {
//		ClientVO clientVO = new ClientVO();
//		return clientVO;
//	}
//	
//	@PUT
//	@Path("/clients/{clientId}")
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//	public ClientVO getClient(@PathParam("clientId") Long clientKey) throws ClientNotFoundException {
//		ClientVO clientVO = new ClientVO();
//		return clientVO;
//	}
//	
//	@DELETE
//	@Path("/clients/{clientId}")
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//	public ClientVO getClient(@PathParam("clientId") Long clientKey) throws ClientNotFoundException {
//		ClientVO clientVO = new ClientVO();
//		return clientVO;
//	}
}
