package org.openhmis.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openhmis.code.ClientHopwaFinancialAssistance;
import org.openhmis.code.ClientSsvfFinancialAssistance;

public class ClientEnrollmentFinancialAssistanceVO {
	private Long financialAssistanceId;
	private Long enrollmentId;

	// Program Specific Data Standards: Financial Assets Provided (2014, 4.15)
	private Date dateProvided;

	// HOPWA (2014, 4.15A)
	private ClientHopwaFinancialAssistance hopwaTypeProvided;
	private Long hopwaFaaAmount;

	// SSVF (2014, 4.15B)
	private ClientSsvfFinancialAssistance ssvfTypeProvided;
	private Long ssvfFaaAmount;

	public ClientEnrollmentFinancialAssistanceVO() {}
}
