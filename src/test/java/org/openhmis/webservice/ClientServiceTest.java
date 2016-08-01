package org.openhmis.webservice;

import static org.junit.Assert.*;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openhmis.test.IntegrationTest;
import org.openhmis.test.BaseIntegrationTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.openhmis.dto.result.ListResultDTO;
import org.openhmis.provider.ObjectMapperContextResolver;
import org.openhmis.provider.WrappingWriterInterceptor;
import org.openhmis.dto.ClientDTO;
import org.json.JSONArray;
import org.json.JSONObject;

@Category(IntegrationTest.class)
public class ClientServiceTest extends BaseIntegrationTest {

    @Override
    protected IDataSet getDataSet() throws Exception {
    	// For these tests we'll just use the default data
    	String path = getClass().getClassLoader().getResource("db/test/default.xml").getPath();
        return new FlatXmlDataSetBuilder().build(new File(path));
    }

    @Test
    public void get_clients_endpoint_should_return_200() {
        final Response response = target("clients").request().get();
        assertEquals(200, response.getStatus());
    }
    
    @Test
    public void get_clients_endpoint_should_return_wrapped_items() {
        final Response response = target("clients").request().get();
        
        String json = response.readEntity(String.class);
        JSONObject result = new JSONObject(json);

        assertTrue("The result should have a data key", result.has("data"));
        assertTrue("The result should have an items key", result.getJSONObject("data").has("items"));
        
    }

    @Test
    public void get_clients_endpoint_should_return_valid_json() {
        final Response response = target("clients").request().get();
        
        String json = response.readEntity(String.class);
        JSONObject result = new JSONObject(json);
        JSONArray clients = result.getJSONObject("data")
        		.getJSONArray("items");

        assertTrue("Length should be greater than 1, but was " + clients.length(), clients.length() > 1);
    }
}