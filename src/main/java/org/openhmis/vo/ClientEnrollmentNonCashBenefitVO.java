package org.openhmis.vo;

import java.util.Date;
import java.util.List;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;


public class ClientEnrollmentNonCashBenefitVO {
	private Long nonCashBenefitId;
	private Long enrollmentId;

	// Program Specific Data Standards: Non-cash Benefits (2014, 4.3)
	private Date informationDate;
	private YesNoReason benefitsFromAnySource;
	private YesNo snap;
	private YesNo wic;
	private YesNo tanfChildCare;
	private YesNo tanfTransportation;
	private YesNo otherTanf;
	private YesNo rentalAssistanceOngoing;
	private YesNo otherBenefitsSource;
	private YesNo rentalAssistanceTemp;
	private String otherBenefitsSourceIdentify;

	public ClientEnrollmentNonCashBenefitVO() {}
}

