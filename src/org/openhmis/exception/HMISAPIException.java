package org.openhmis.exception;

public class HMISAPIException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4383743184249577734L;
	
	private String message = null;

    public HMISAPIException() 
    {
        super();
    }

    public HMISAPIException(String message) {
        super(message);
        this.message = message;
    }

    public HMISAPIException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() 
    {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
