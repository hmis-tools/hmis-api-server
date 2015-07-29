package org.openhmis.vo;

import java.util.Date;
import java.util.List;

import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;

public class ClientEnrollmentChronicHealthConditionVO {
	private Long chronicHealthConditionId;
	private Long enrollmentId;

	// Program Specific Data Standards: Chronic Health Condition (2014, 4.7)
	private Date informationDate;
	private YesNoReason response;
	private YesNoReason indefiniteAndImpairs;
	private YesNo documentationOnFile;
	private YesNoReason receivingServices;

	public ClientEnrollmentChronicHealthConditionVO() {}
}

