package org.openhmis.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.openhmis.dto.error.InvalidParameterErrorDTO;
import org.openhmis.dto.error.RecordNotFoundErrorDTO;
import org.openhmis.dto.error.RootErrorDTO;

public class InvalidParameterException extends WebApplicationException {
     /**
      * Create a HTTP 404 (Not Found) exception.
      */
     public InvalidParameterException() {
         super(Response
        		 .status(Response.Status.BAD_REQUEST)
        		 .entity(new RootErrorDTO(new InvalidParameterErrorDTO()))
        		 .build());
     }
  
 }