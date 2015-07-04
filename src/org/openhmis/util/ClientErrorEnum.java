package org.openhmis.util;

public enum ClientErrorEnum 
{
	AUTHENTICATION_ERROR("Authentication Error");
	
	private ClientErrorEnum(String value)
	{
		this.value = value;
	}
	
	private String value;

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
