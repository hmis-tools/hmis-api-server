package org.openhmis.vo;

import java.util.Date;
import org.openhmis.code.ClientDisabilityResponse;
import org.openhmis.code.ClientPathHowConfirmed;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;


public class ClientEnrollmentSubstanceAbuseVO {
	private Long substanceAbuseId;
	private Long enrollmentId;

	// Program Specific Data Standards: Substance Abuse (2014, 4.10)
	private Date informationDate;
	private ClientDisabilityResponse response;
	private YesNoReason indefiniteAndImpairs;
	private YesNo documentationOnFile;
	private YesNoReason receivingServices;
	private ClientPathHowConfirmed pathHowConfirmed;

	public ClientEnrollmentSubstanceAbuseVO() {}
}

