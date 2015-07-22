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
public class ClientEnrollmentNonCashBenefitVO implements Serializable {
	private Long enrollmentId;

	// Program Specific Data Standards: Non-cash Benefits (2014, 4.3)
	private Date informationDate;
	private Integer benefitsFromAnySourceCode;
	private Integer benefitsSnapCode;
	private Integer benefitsWicCode;
	private Integer benefitsTanfChildCareCode;
	private Integer benefitsTanfTransportationCode;
	private Integer benefitsTanfOtherCode;
	private Integer benefitsSection8Code;
	private Integer benefitsOtherSourceCode;
	private Integer benefitsTemporaryRentalCode;
	private String benefitsOtherSource;

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

