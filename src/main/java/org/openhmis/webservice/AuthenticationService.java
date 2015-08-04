package org.openhmis.webservice;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.openhmis.code.ClientNameDataQuality;
import org.openhmis.dto.ClientDTO;
import org.openhmis.manager.ClientManager;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Path("/oauth2")
public class ClientService {
	private static final Logger log = Logger.getLogger(ClientService.class);
	private static final ObjectMapper om = new ObjectMapper();
	private static final ClientManager clientManager = new ClientManager();

	public ClientService() {}

	@GET
	@Path("authorize")
	public Response authorize(@QueryParam("code") String code, @QueryParam("state") String state) {
		final OAuth2CodeGrantFlow flow = SimpleOAuthService.getFlow();

		final TokenResult tokenResult = flow.finish(code, state);

		SimpleOAuthService.setAccessToken(tokenResult.getAccessToken());

		// authorization is finished -> now redirect back to the task resource
		final URI uri = UriBuilder.fromUri(uriInfo.getBaseUri()).path("tasks").build();
		return Response.seeOther(uri).build();
	}

	@GET
	@Path("/callback")
	@Produces({MediaType.APPLICATION_JSON})
	public String callback(@PathParam("personalId") String personalId) throws JsonProcessingException {
		ClientDTO clientDTO = clientManager.getClientByPersonalId(personalId);
		return om.writeValueAsString(clientDTO);
	}
}
