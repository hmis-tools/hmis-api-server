package org.openhmis.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.openhmis.dto.error.AccessDeniedErrorDTO;
import org.openhmis.dto.error.RootErrorDTO;

public class AccessDeniedException extends WebApplicationException {
     /**
      * Create a HTTP 404 (Not Found) exception.
      */
     public AccessDeniedException() {
         super(Response
        		 .status(Response.Status.NOT_FOUND)
        		 .entity(new RootErrorDTO(new AccessDeniedErrorDTO()))
        		 .build());
     }
  
 }