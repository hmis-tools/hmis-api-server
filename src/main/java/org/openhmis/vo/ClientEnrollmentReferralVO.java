package org.openhmis.vo;

import java.util.Date;
import java.util.List;

import org.openhmis.code.ClientPathReferral;
import org.openhmis.code.ClientPathReferralOutcome;
import org.openhmis.code.ClientRhyReferral;


public class ClientEnrollmentReferralVO {
	private Long referralId;
	private Long enrollmentId;

	// Program Specific Data Standards: References Provided (2014, 4.16)
	private Date referralDate;

	// PATH (2014, 4.16A)
	private ClientPathReferral pathTypeProvided;
	private ClientPathReferralOutcome referralOutcome;

	// RHY (2014, 4.16B)
	private ClientRhyReferral rhyTypeProvided;

	public ClientEnrollmentReferralVO() {}
}
