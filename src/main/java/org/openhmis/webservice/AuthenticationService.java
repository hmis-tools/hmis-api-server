package org.openhmis.webservice;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;

import org.apache.log4j.Logger;
import org.openhmis.code.ClientNameDataQuality;
import org.openhmis.dto.ClientDTO;
import org.openhmis.manager.ClientManager;

import org.openhmis.exception.AccessDeniedException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Properties;

import org.openhmis.util.Authentication;
import org.openhmis.util.ApplicationPropertyUtil;

@Path("/authenticate")
public class AuthenticationService {

	public AuthenticationService() {}
	private static final Logger log = Logger.getLogger(ClientService.class);
    
	@POST
	@Path("/google")
	public String authenticate(@Context SecurityContext sc, String code) {
                log.info("AUTHN POST /google/ (" + code + ")");
		return Authentication.getGoogleToken(code);
	}

	@GET
	@Path("/google/client_key")
	public String googleClientKey() {
                log.info("AUTHN GET /google/client_key");
		ApplicationPropertyUtil applicationPropertyUtil = new ApplicationPropertyUtil();
		return applicationPropertyUtil.getGoogleClientId();
	}

	@POST
	@Path("/externalId")
	public String getExternalId(@HeaderParam("Authorization") String authorization, String id_token) {
                /*
                 * We probably don't need to limit access to this
                 * endpoint to those with READ privileges on our server,
                 * since Google provides services to find a person's
                 * name from an id token, but we prefer to use an
                 * abundance of caution.
                 */
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                log.info("AUTHN POST /externalId/ " + id_token);
                String externalId = Authentication.resolveIdentity(id_token);
                return externalId;
	}

        

}
