package org.openhmis.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.openhmis.dto.errors.RecordNotFoundErrorDTO;
import org.openhmis.dto.errors.RootErrorDTO;

public class InvalidParameterException extends WebApplicationException {
     /**
      * Create a HTTP 404 (Not Found) exception.
      */
     public InvalidParameterException() {
         super(Response
        		 .status(Response.Status.NOT_FOUND)
        		 .entity(new RootErrorDTO(new InvalidParameterErrorDTO()))
        		 .build());
     }
  
 }