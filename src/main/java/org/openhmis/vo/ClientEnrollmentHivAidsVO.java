package org.openhmis.vo;

import java.util.Date;
import java.util.List;

import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;

public class ClientEnrollmentHivAidsVO {
	private Long hivAidsId;
	private Long enrollmentId;

	// Program Specific Data Standards: HIV/AIDS (2014, 4.8)
	private Date informationDate;
	private YesNoReason response;
	private YesNoReason indefiniteAndImpairs;
	private YesNo documentationOnFile;
	private YesNoReason receivingServices;

	public ClientEnrollmentHivAidsVO() {}
}

