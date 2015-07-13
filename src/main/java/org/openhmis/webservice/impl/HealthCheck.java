package org.openhmis.webservice.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "healthcheck" path)
 */
@Path("healthcheck")
public class HealthCheck {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String healthcheck() {
        return "Your service is working.";
    }

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/migrate")
    public String migrate() {

        // Migrations require a session to work
        if(System.getenv("DATABASE_URL") != null) {
            Flyway flyway = new Flyway();
            URI envDbUri = new URI(System.getenv("DATABASE_URL"));
            String username = envDbUri.getUserInfo().split(":")[0];
            String password = envDbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:" + envDbUri.getScheme() + "://" + envDbUri.getHost() + ':' + envDbUri.getPort() + envDbUri.getPath();

            flyway.setDataSource(dbUrl, username, password);
            flyway.migrate();
            return "Done."
        } else {
            return "Not Configured."
        }
    }
}
