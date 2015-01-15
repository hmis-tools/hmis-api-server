/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

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
