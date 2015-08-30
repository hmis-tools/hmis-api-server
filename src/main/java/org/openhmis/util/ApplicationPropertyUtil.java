package org.openhmis.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationPropertyUtil {
	InputStream input = null;
	Properties properties = new Properties();
	String propFileName = "application.properties";
	
	public ApplicationPropertyUtil() {
		
	}

	private void loadPropertiesFile() throws Exception {
		try {
			input = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (input != null) {
				properties.load(input);
			}
			else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} catch(Exception e) {
			throw new Exception("Unable to read property file " + e.getMessage());
		} finally {
			if (input != null) {
				try
				{
					input.close();
				}
				catch(Exception e)
				{
					throw new Exception("Unable to close input stream " + e.getMessage());
				}
			}
		}
	}

	public String getApplicationVersion() {
		try {
			loadPropertiesFile();
		} catch (Exception e) {
			return "";
		}

		return properties.getProperty("application.version");
	}

	public String getGoogleClientId() {
		try {
			loadPropertiesFile();
		} catch (Exception e) {
			return "";
		}

		return properties.getProperty("google.clientId");
	}

	public String getGoogleSecret() {
		try {
			loadPropertiesFile();
		} catch (Exception e) {
			return "";
		}

		return properties.getProperty("google.secret");
	}

}
