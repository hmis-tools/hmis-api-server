package org.openhmis.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.openhmis.dto.error.InvalidParameterErrorDTO;
import org.openhmis.dto.error.RecordNotFoundErrorDTO;
import org.openhmis.dto.error.RootErrorDTO;

public class InvalidParameterException extends WebApplicationException {
     
     public InvalidParameterException() {
         super(Response
        		 .status(Response.Status.BAD_REQUEST)
        		 .entity(new RootErrorDTO(new InvalidParameterErrorDTO()))
        		 .build());
     }

     public InvalidParameterException(String parameter, String problem) {
         super(Response
        		 .status(Response.Status.BAD_REQUEST)
        		 .entity(new RootErrorDTO(new InvalidParameterErrorDTO(parameter, problem)))
        		 .build());
     }
  
 }