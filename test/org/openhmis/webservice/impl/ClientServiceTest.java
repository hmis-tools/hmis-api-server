/**
 * 
 */
package org.openhmis.webservice.impl;

import static org.junit.Assert.fail;

import java.net.URI;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Ashaar Riaz
 *
 */
public class ClientServiceTest extends JerseyTest
{
	@Override
	protected Application configure() 
	{
		return new ResourceConfig(ClientService.class);
	}
	
//	@Override
//	protected URI getBaseUri() 
//	{
//		return UriBuilder.fromUri(super.getBaseUri()).path("services").build();
//	}
//


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.openhmis.webservice.impl.ClientService#getClient(java.lang.Long)}.
	 */
	@Test
	public void testGetClient() 
	{
		 Response response = target().path("clients").request(MediaType.APPLICATION_XML).get();
		 Assert.assertEquals(
	                String.format("Response status should be 200. Current value is %d.", response.getStatus()),
	            200, response.getStatus());
	}

	/**
	 * Test method for {@link org.openhmis.webservice.impl.ClientService#getClientByLastName(java.lang.String)}.
	 */
	@Test
	public void testGetClientByLastName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.openhmis.webservice.impl.ClientService#addClient(javax.xml.bind.JAXBElement)}.
	 */
	@Test
	public void testAddClient() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.openhmis.webservice.impl.ClientService#updateClient(java.lang.Long, javax.xml.bind.JAXBElement)}.
	 */
	@Test
	public void testUpdateClient() {
		fail("Not yet implemented");
	}

}
