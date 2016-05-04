package org.openhmis.provider;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.glassfish.jersey.spi.ExtendedExceptionMapper;

@Provider
public class LoggerExceptionMapper implements ExceptionMapper<Throwable> {
    private static final Logger log = Logger.getLogger(LoggerExceptionMapper.class);
    
    public Response toResponse(Throwable t) {
        log.error("Uncaught exception thrown by REST service", t);
        if (t instanceof WebApplicationException) {
            return ((WebApplicationException)t).getResponse();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                   // Add an entity, etc.
                   .build();
        }
    }
}