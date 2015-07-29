package org.openhmis.vo;

import java.util.Date;
import java.util.List;

import org.openhmis.code.ClientWhenDvOccurred;
import org.openhmis.code.YesNoReason;


public class ClientEnrollmentDomesticAbuseVO {
	private Long domesticAbuseId;
	private Long enrollmentId;

	// Program Specific Data Standards: Domestic Abuse (2014, 4.11)
	private Date informationDate;
	private YesNoReason domesticViolenceVictim;
	private ClientWhenDvOccurred whenOccurred;

	public ClientEnrollmentDomesticAbuseVO() {}
}