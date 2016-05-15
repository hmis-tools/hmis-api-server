package org.openhmis.dao;
import junit.framework.Assert;

import org.flywaydb.test.annotation.FlywayTest;
import org.flywaydb.test.dbunit.DBUnitSupport;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import org.openhmis.test.IntegrationTest;

@FlywayTest
@DBUnitSupport
@Category(IntegrationTest.class)
public class PathClientDAOTest {

	@Test
	public void testPrintHelloWorld() {

		Assert.assertEquals("Hello World", "Hello World");

	}

}