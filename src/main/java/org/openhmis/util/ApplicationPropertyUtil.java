package org.openhmis.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationPropertyUtil 
{
	InputStream input = null;
	Properties properties = new Properties();
	String propFileName = "application.properties";
	
	public ApplicationPropertyUtil()
	{
		
	}
	public String getApplicationVersion() throws Exception
	{
		String applicationVersion = "";
		try
		{
			input = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (input != null)
			{
				properties.load(input);
			}
			else 
			{
					throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			applicationVersion = properties.getProperty("application.version");
	 
		}
		catch(Exception e)
		{
			throw new Exception("Unable to read property file " + e.getMessage());
		}
		finally
		{
			if (input != null)
			{
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
		return applicationVersion;
	}
}
