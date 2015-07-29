package org.openhmis.vo;

import java.util.Date;
import java.util.List;

import org.openhmis.code.ClientReasonNotInsured;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;

public class ClientEnrollmentHealthInsuranceVO {
	private Long healthInsuranceId;
	private Long enrollmentId;

	// Program Specific Data Standards: Health Insurance (2014, 4.4)
	private Date informationDate;
	private YesNoReason insuranceFromAnySource;
	private YesNo medicaid;
	private ClientReasonNotInsured noMedicaidReason;
	private YesNo medicare;
	private ClientReasonNotInsured noMedicareReason;
	private YesNo schip;
	private ClientReasonNotInsured noSchipReason;
	private YesNo vaMedicalServices;
	private ClientReasonNotInsured noVaMedReason;
	private YesNo employerProvided;
	private ClientReasonNotInsured noEmployerProvidedReason;
	private YesNo cobra;
	private ClientReasonNotInsured noCobraReason;
	private YesNo privatePay;
	private ClientReasonNotInsured noPrivatePayReason;
	private YesNo stateHealthIns;
	private ClientReasonNotInsured noStateHealthInsReason;

	public ClientEnrollmentHealthInsuranceVO() {}
}

