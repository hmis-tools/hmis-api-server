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

import org.openhmis.code.ClientReasonNotInsured;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;



@XmlRootElement
public class ClientEnrollmentHealthInsuranceVO implements Serializable {
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

	public ClientEnrollmentHealthInsuranceVO() {
		super();
	}
	public ClientEnrollmentHealthInsuranceVO(Long enrollmentId) {
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

