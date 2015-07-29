/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;



@XmlRootElement
public class ClientEnrollmentIncomeSourceVO implements Serializable {
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

	public ClientEnrollmentIncomeSourceVO() {
		super();
	}
	public ClientEnrollmentIncomeSourceVO(Long enrollmentId) {
		super();
		this.enrollmentId = enrollmentId;
	}

	@Override
	public int hashCode() {
		return 0;
	}
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	@Override
	public String toString() {
		return "";
	}
}

