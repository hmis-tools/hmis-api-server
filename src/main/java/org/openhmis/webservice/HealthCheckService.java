package org.openhmis.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.openhmis.util.ApplicationPropertyUtil;
import org.openhmis.util.Authentication;

/**
 * Root resource (exposed at "healthcheck" path)
 */
@Path("healthcheck")
public class HealthCheckService {
	
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
        return "Your service is working with version " + applicationPropertyUtil.getApplicationVersion();
    }

    @GET
    @Path("/authentication")
    @Produces(MediaType.TEXT_PLAIN)
    public String authenticationHealthcheck(@HeaderParam("Authorization") String authorization) {
    	if(authorization == null)
    		return "Your Authorization header isn't set.";

    	if(Authentication.googleAuthenticate(authorization))
    		return "You have a valid authorization token;";
    				
    	return "You are not authenticated";
    }

}
