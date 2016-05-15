package org.openhmis.util;

import java.io.InputStream;
import java.util.Properties;

public class ApplicationPropertyUtil {
	Properties properties = new Properties();

	public ApplicationPropertyUtil() {
		
	}

	private void loadPropertiesFile() {
		try {
            String environment = System.getProperty("ENV", "dev");
	    	String configFileName = environment + ".properties";
	    	
    		InputStream is = getClass().getClassLoader().getResourceAsStream(configFileName);
    		properties.load(is);
    		is.close();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Properties getProperties() {
		loadPropertiesFile();
		return properties;
	}

	public String getApplicationVersion() {
		loadPropertiesFile();
		return properties.getProperty("application.version");
	}

	public String getGoogleClientId() {
		loadPropertiesFile();
		return properties.getProperty("google.clientId");
	}

	public String getGoogleSecret() {
		loadPropertiesFile();
		return properties.getProperty("google.secret");
	}

    public Boolean getAuthEnabled() {
        loadPropertiesFile();
        Boolean authEnabled = Boolean.parseBoolean(properties.getProperty("authEnabled"));
        return authEnabled;
    }
}
