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
public class ClientEnrollmentNonCashBenefitVO implements Serializable {
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

	public ClientEnrollmentNonCashBenefitVO() {
		super();
	}
	public ClientEnrollmentNonCashBenefitVO(Long enrollmentId) {
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

