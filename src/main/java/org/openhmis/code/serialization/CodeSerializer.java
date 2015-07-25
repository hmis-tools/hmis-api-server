package org.openhmis.code.serialization;

import java.io.IOException;

import org.openhmis.code.BaseCode;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CodeSerializer extends JsonSerializer<BaseCode> {
 
    public void serialize
      (BaseCode value, JsonGenerator generator, SerializerProvider provider) 
      throws IOException, JsonProcessingException {
        generator.writeStartObject();
        generator.writeFieldName("code");
        generator.writeNumber(value.getCode());
        generator.writeFieldName("description");
        generator.writeString(value.getDescription());
        generator.writeEndObject();
    }
}