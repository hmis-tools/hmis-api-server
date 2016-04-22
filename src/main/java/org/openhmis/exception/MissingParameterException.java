package org.openhmis.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.openhmis.dto.error.MissingParameterErrorDTO;
import org.openhmis.dto.error.RootErrorDTO;

public class MissingParameterException extends WebApplicationException {
     /**
      * Create a HTTP 404 (Not Found) exception.
      */
     public MissingParameterException() {
         super(Response
        		 .status(Response.Status.BAD_REQUEST)
        		 .entity(new RootErrorDTO(new MissingParameterErrorDTO()))
        		 .build());
     }
  
 }