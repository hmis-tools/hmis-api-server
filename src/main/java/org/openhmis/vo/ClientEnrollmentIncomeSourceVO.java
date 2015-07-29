package org.openhmis.vo;

import java.util.Date;
import java.util.List;

import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;

public class ClientEnrollmentIncomeSourceVO {
	private Long incomeSourceId;
	private Long enrollmentId;

	// Program Specific Data Standards: Income Sources (2014, 4.2)
	private Date informationDate;
	private YesNoReason incomeFromAnySourceCode;
	private Double totalMonthlyIncome;
	private YesNo earned;
	private Double earnedAmount;
	private YesNo unemployment;
	private Double unemploymentAmount;
	private YesNo ssi;
	private Double ssiAmount;
	private YesNo ssdi;
	private Double ssdiAmount;
	private YesNo vaDisabilityService;
	private Double vaDisabilityServiceAmount;
	private YesNo vaDisabilityNonService;
	private Double vaDisabilityNonServiceAmount;
	private YesNo privateDisability;
	private Double privateDisabilityAmount;
	private YesNo workerscomp;
	private Double workersCompAmount;
	private YesNo tanf;
	private Double tanfAmount;
	private YesNo ga;
	private Double gaAmount;
	private YesNo socSecRetirement;
	private Double socSecRetirementAmount;
	private YesNo pension;
	private Double pensionAmount;
	private YesNo childSupport;
	private Double childSupportAmount;
	private YesNo alimony;
	private Double alimonyAmount;
	private YesNo otherIncomeSource;
	private Double otherIncomeAmount;

	public ClientEnrollmentIncomeSourceVO() {}
}

