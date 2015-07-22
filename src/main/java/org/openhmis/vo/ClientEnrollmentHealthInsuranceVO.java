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
public class ClientEnrollmentHealthInsuranceVO implements Serializable {
	private Long enrollmentId;

	// Program Specific Data Standards: Health Insurance (2014, 4.4)
	private Date healthInsuranceInformationDate;
	private Integer coveredByHealthInsuranceCode;
	private Integer healthInsuranceMedicaidCode;
	private Integer healthInsuranceNoMedicaidReasonCode;
	private Integer healthInsuranceMedicareCode;
	private Integer healthInsuranceNoMedicareReasonCode;
	private Integer healthInsuranceStateChildrensHealthInsuranceCode;
	private Integer healthInsuranceNoStateChildrenReasonCode;
	private Integer healthInsuranceVaMedicalServicesCode;
	private Integer healthInsuranceNoVaMedicalServicesReasonCode;
	private Integer healthInsuranceEmployerProvidedCode;
	private Integer healthInsuranceNoEmployerProvidedReasonCode;
	private Integer healthInsuranceCobraCode;
	private Integer healthInsuranceNoCobraReasonCode;
	private Integer healthInsurancePrivatePayCode;
	private Integer healthInsuranceNoPrivatePayReasonCode;
	private Integer healthInsuranceStateAdultsCode;
	private Integer healthInsuranceNoStateAdultsReasonCode;

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

