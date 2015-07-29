package org.openhmis.vo;

import java.util.Date;
import java.util.List;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;


public class ClientEnrollmentPhysicalDisabilityVO {
	private Long physicalDisabilityId;
	private Long enrollmentId;

	// Program Specific Data Standards: Physical Disability (2014, 4.5)
	private Date informationDate;
	private YesNoReason response;
	private YesNoReason indefiniteAndImpairs;
	private YesNo documentationOnFile;
	private YesNoReason receivingServices;


	public ClientEnrollmentPhysicalDisabilityVO() {}
}

