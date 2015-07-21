package org.openhmis.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ValidationError
{
	private String propertyName;
    private String propertyValue;
    private String message;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}