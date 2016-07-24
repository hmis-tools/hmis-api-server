package org.openhmis.test;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openhmis.util.ApplicationPropertyUtil;
import org.openhmis.util.HibernateSessionFactory;
import org.openhmis.webservice.ClientService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.openhmis.dto.result.ListResultDTO;
import org.openhmis.provider.ObjectMapperContextResolver;
import org.openhmis.provider.WrappingWriterInterceptor;
import org.openhmis.dto.ClientDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import org.flywaydb.core.Flyway;

public class BaseIntegrationTest extends JerseyTest {

	private Session session; 
	private Properties properties;
	
    @Override
    protected Application configure() {
    	
    	// Spread the word that this is a test
    	// TODO: This isn't the right way to do this.
    	System.setProperty("ENV", "test");
    	
    	// Load the database properties (for DBUnit)
    	ApplicationPropertyUtil propertyUtil = new ApplicationPropertyUtil();
		this.properties = propertyUtil.getProperties();
    	
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
//        IDataSet dataSet = getDataSet();
//        cleanlyInsert(dataSet);
    }

    private void cleanlyInsert(IDataSet dataSet) throws Exception {
    	ApplicationPropertyUtil properties = new ApplicationPropertyUtil();
        IDatabaseTester databaseTester = new JdbcDatabaseTester(
        		this.properties.getProperty("hibernate.dialect"),
        		this.properties.getProperty("hibernate.connection.url"),
        		this.properties.getProperty("hibernate.connection.username"),
        		this.properties.getProperty("hibernate.connection.password"));
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }

    protected IDataSet getDataSet() throws Exception {  
        throw new Exception("Specify data set for test: " + this.getClass().getSimpleName());  
    }

    @Override
    public void setUp() throws Exception
    {
//        super.setUp();
//
//        // initialize your database connection here
//        IDatabaseConnection connection = null;
//        // ...
//
//        // initialize your dataset here
//        IDataSet dataSet = null;
//        // ...
//
//        try
//        {
//            DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
//        }
//        finally
//        {
//            connection.close();
//        }
    }
}