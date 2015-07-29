package org.openhmis.vo;

import java.util.Date;
import java.util.List;

import org.openhmis.code.ClientPathHowConfirmed;
import org.openhmis.code.ClientPathSmiInformation;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;

public class ClientEnrollmentMentalHealthProblemVO {
	private Long mentalHealthProblemId;
	private Long enrollmentId;

	// Program Specific Data Standards: Mental Health Problem (2014, 4.9)
	private Date informationDate;
	private YesNoReason response;
	private YesNoReason indefiniteAndImpairs;
	private YesNo documentationOnFile;
	private YesNoReason receivingServices;
	private ClientPathHowConfirmed pathHowConfirmed;
	private ClientPathSmiInformation pathSmiInformation;

	public ClientEnrollmentMentalHealthProblemVO() {}
}

