package org.openhmis.code.serialization;

import java.io.IOException;

import org.openhmis.code.ClientNameDataQuality;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CodeSerializer extends JsonSerializer<ClientNameDataQuality> {
 
    public void serialize
      (ClientNameDataQuality value, JsonGenerator generator, SerializerProvider provider) 
      throws IOException, JsonProcessingException {
        generator.writeStartObject();
        generator.writeFieldName("code");
        generator.writeNumber(value.getCode());
        generator.writeFieldName("description");
        generator.writeString(value.getDescription());
        generator.writeEndObject();
    }
}