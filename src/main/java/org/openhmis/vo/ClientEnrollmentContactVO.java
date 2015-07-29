package org.openhmis.vo;

import java.util.Date;
import java.util.List;

import org.openhmis.code.ClientContactLocation;

public class ClientEnrollmentContactVO {
	private Long contactId;
	private Long enrollmentId;

	// Program Specific Data Standards: Contact (2014, 4.12)
	private Date dateProvided;
	private ClientContactLocation typeProvided;
	
	public ClientEnrollmentContactVO() {}
	
}
