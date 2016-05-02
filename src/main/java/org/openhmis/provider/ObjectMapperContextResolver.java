package org.openhmis.provider;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper>  {

    final ObjectMapper mapper = new ObjectMapper();

    public ObjectMapperContextResolver() {

    	// To see a list of all 
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, true);
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }  
}