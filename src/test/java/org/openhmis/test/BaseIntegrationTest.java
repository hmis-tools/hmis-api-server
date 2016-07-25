package org.openhmis.test;

import java.util.Properties;

import javax.ws.rs.core.Application;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openhmis.util.ApplicationPropertyUtil;
import org.openhmis.webservice.ClientService;

import org.openhmis.provider.ObjectMapperContextResolver;
import org.openhmis.provider.WrappingWriterInterceptor;

import org.flywaydb.core.Flyway;

public class BaseIntegrationTest extends JerseyTest {
	
    @Override
    protected Application configure() {
    	
    	// Spread the word that this is a test
    	// TODO: This isn't the right way to do this, we shouldn't be using environment variables
    	System.setProperty("ENV", "test");
    	
		// Set up the test server resources
    	ResourceConfig rc = new ResourceConfig()
            .register(ClientService.class)
            .register(ObjectMapperContextResolver.class)
            .register(WrappingWriterInterceptor.class);
    	
        return rc;
    }

    @BeforeClass
    public static void createSchema() throws Exception {
    	
    	// Run the latest migrations using Flyway
    	ApplicationPropertyUtil propertyUtil = new ApplicationPropertyUtil();
		Properties properties = propertyUtil.getProperties();
    	Flyway flyway = new Flyway();
        flyway.setDataSource(
        	properties.getProperty("hibernate.connection.url"),
        	properties.getProperty("hibernate.connection.username"),
        	properties.getProperty("hibernate.connection.password"));
        flyway.migrate();

    }

    @Before
    public void importDataSet() throws Exception {
    	
    	// Create a clean copy of all data before each test
        IDataSet dataSet = getDataSet();
        cleanlyInsert(dataSet);
        
    }

    private void cleanlyInsert(IDataSet dataSet) throws Exception {
    	ApplicationPropertyUtil propertyUtil = new ApplicationPropertyUtil();
		Properties properties = propertyUtil.getProperties();
        IDatabaseTester databaseTester = new JdbcDatabaseTester(
        		properties.getProperty("hibernate.dialect"),
        		properties.getProperty("hibernate.connection.url"),
        		properties.getProperty("hibernate.connection.username"),
        		properties.getProperty("hibernate.connection.password"));
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }

    protected IDataSet getDataSet() throws Exception {  
        throw new Exception("Specify data set for test: " + this.getClass().getSimpleName());  
    }
}