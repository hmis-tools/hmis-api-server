package org.openhmis.webservice;

import static org.junit.Assert.*;

import java.util.List;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openhmis.test.IntegrationTest;
import org.openhmis.dto.result.ListResultDTO;

@Category(IntegrationTest.class)
public class ClientServiceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(ClientService.class);
    }

    @Test
    public void get_clients_endpoint_should_return_200() {
        final Response response = target("clients").request().get();
        assertEquals(response.getStatus(), 200);
    }

    @Test
    public void get_clients_endpoint_should_return_valid_json() {
        final Response response = target("clients").request().get();
        ListResultDTO clients = response.readEntity(ListResultDTO.class);
        assertEquals(clients.getItems().size(),15);
    }
}