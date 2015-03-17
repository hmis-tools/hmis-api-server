package org.openhmis.service.impl;


import org.openhmis.exception.oauth2.UnableToAuthorizeException;
import org.openhmis.service.AuthenticateManager;

public class TestMain {
	//private AuthenticateManager authenticateManager;
	
	AuthenticateManager authenticateManager = new AuthenticateManagerImpl();

    public void TestAuth(){
    	System.out.println("<<<<<<< TestAuth >>>>>>>>>>");
    	try {
			boolean isAuthenticate = authenticateManager.authenticateUser("welcome", "welcome@developer.gserviceaccount.com");
			System.out.println("<<<<<<<<< isAuthenticate : " + isAuthenticate);
		} catch (UnableToAuthorizeException e) {
			e.printStackTrace();
		}
    	
    }
	

	public static void main(String[] args) {

		TestMain testMain =new TestMain();
		testMain.TestAuth();

	}

}
