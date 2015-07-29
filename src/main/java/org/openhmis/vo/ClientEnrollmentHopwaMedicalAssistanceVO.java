package org.openhmis.vo;

import java.util.Date;
import java.util.List;

import org.openhmis.code.ClientNoAssistanceReason;
import org.openhmis.code.YesNoReason;


public class ClientEnrollmentHopwaMedicalAssistanceVO {
	private Long hopwaMedicalAssistanceId;
	private Long enrollmentId;

	// HOPWA Specific Data Standards: Medical Assistance (2014, 4.39)
	private Date informationDate;
	private YesNoReason hivAidsAssistance;
	private ClientNoAssistanceReason noHivAidsAssistanceReason;
	private YesNoReason adap;
	private ClientNoAssistanceReason noAdapReason;

	public ClientEnrollmentHopwaMedicalAssistanceVO() {}
}

