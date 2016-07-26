package org.openhmis.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.openhmis.util.ApplicationPropertyUtil;
import org.openhmis.util.Authentication;

/**
 * Root resource (exposed at "healthcheck" path)
 */
@Path("healthcheck")
public class HealthCheckService {
	private static final Logger log = Logger.getLogger(ClientService.class);
	
	ApplicationPropertyUtil applicationPropertyUtil = null;
	
	public HealthCheckService()
	{
		applicationPropertyUtil = new ApplicationPropertyUtil();
	}

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws Exception 
     */
    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String healthcheck() throws Exception {
        log.info("GET /healthcheck/ ");
        return "Your service is working with version " + applicationPropertyUtil.getApplicationVersion();
    }

    @GET
    @Path("/authentication")
    @Produces(MediaType.TEXT_PLAIN)
    public String authenticationHealthcheck(@HeaderParam("Authorization") String authorization) {
        /* To avoid possible confusion: Yes, the HTTP header is named
           (or mis-named) "Authorization", but the process we're
           talking about here is authentication, so we use the latter
           term except when referring to the header itself. */
    	if(authorization == null) {
                log.info("GET /healthcheck/authentication (Failed)");
                return "Unable to authenticate, because the HTTP Authorization header isn't set.";
        }

    	if(Authentication.googleAuthenticate(authorization)) {
                log.info("GET /healthcheck/authentication (Success)");
    		return "You have a valid authentication token.";
        }
    				
    	return "You are not authenticated";
    }

}
