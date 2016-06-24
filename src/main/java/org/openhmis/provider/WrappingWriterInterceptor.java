package org.openhmis.provider;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

import org.openhmis.dto.error.AbstractErrorDTO;
import org.openhmis.dto.error.RootErrorDTO;
import org.openhmis.dto.result.DataResultDTO;
import org.openhmis.dto.result.ListResultDTO;
import org.openhmis.dto.BaseDTO;

@Provider
public class WrappingWriterInterceptor implements WriterInterceptor {
    @Override
    public void aroundWriteTo(WriterInterceptorContext context)
                    throws IOException, WebApplicationException {
        
        // We want to wrap data objects so their structure is similar to the error objects
        Object currentEntity = context.getEntity();
        
        // If this is an error, continue normally
        // TODO: error wrapper should be applied here as well
        if(currentEntity instanceof List) {
			ListResultDTO resultDTO = new ListResultDTO((List<Object>) currentEntity);
            context.setEntity(resultDTO);
            context.setGenericType(ListResultDTO.class);
            context.setType(ListResultDTO.class);           
        } else if(currentEntity instanceof BaseDTO) {
            DataResultDTO resultDTO = new DataResultDTO(currentEntity);
            context.setEntity(resultDTO);
            context.setGenericType(DataResultDTO.class);
            context.setType(DataResultDTO.class);
        }
        
        context.proceed();
    }
}