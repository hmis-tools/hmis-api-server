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



@XmlRootElement
public class ClientEnrollmentIncomeSourceVO implements Serializable {
	private Long enrollmentId;

	// Program Specific Data Standards: Income Sources (2014, 4.2)
	private Date informationDate;
	private Integer incomeFromAnySourceCode;
	private Integer incomeEarnedCode;
	private Double incomeEarnedMonthlyAmount;
	private Integer incomeUnemploymentInsuranceCode;
	private Double incomeUnemploymentInsuranceMonthlyAmount;
	private Integer incomeSupplementalSecurityCode;
	private Double incomeSupplementalSecurityMonthlyAmount;
	private Integer incomeSocialSecurityDisabilityCode;
	private Double incomeSocialSecurityDisabilityMonthlyAmount;
	private Integer incomeVaServiceDisabilityCode;
	private Double incomeVaServiceDisabilityMonthlyAmount;
	private Integer incomeVaNonServiceDisabilityCode;
	private Double incomeVaNonServiceDisabilityMonthlyAmount;
	private Integer incomePrivateDisabilityInsuranceCode;
	private Double incomePrivateDisabilityInsuranceMonthlyAmount;
	private Integer incomeWorkersCompensationCode;
	private Double incomeWorkersCompensationMonthlyAmount;
	private Integer incomeTemporaryAssistanceForNeedyFamiliesCode;
	private Double incomeTemporaryAssistanceForNeedyFamiliesMonthlyAmount;
	private Integer incomeGeneralAssistanceCode;
	private Double incomeGeneralAssistanceMonthlyAmount;
	private Integer incomeChildSupportCode;
	private Double incomeChildSupportMonthlyAmount;
	private Integer incomeAlimonyCode;
	private Double incomeAlimonyMonthlyAmount;

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

