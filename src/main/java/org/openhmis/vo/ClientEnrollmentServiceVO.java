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

import org.openhmis.code.ClientHopwaServices;
import org.openhmis.code.ClientPathServices;
import org.openhmis.code.ClientRhyServices;
import org.openhmis.code.ClientSsvfServices;
import org.openhmis.code.ClientSsvfSubType3;
import org.openhmis.code.ClientSsvfSubType4;
import org.openhmis.code.ClientSsvfSubType5;



@XmlRootElement
public class ClientEnrollmentServiceVO implements Serializable {
	private Long enrollmentId;

	// Program Specific Data Standards: Services Provided (2014, 4.14)
	private Date dateProvided;

	// PATH (2014, 4.14A)
	private ClientPathServices pathTypeProvided;

	// RHY (2014, 4.14B)
	private ClientRhyServices rhyTypeProvided;
	
	// HOPWA (2014, 4.14C)
	private ClientHopwaServices hopwaTypeProvided;

	// SSVF (2014, 4.14D)
	private ClientSsvfServices ssvfTypeProvided;
	private ClientSsvfSubType3 ssvfVaSubTypeProvided;
	private ClientSsvfSubType4 ssvfCoordinatingSubTypeProvided;
	private ClientSsvfSubType5 ssvfDirectSubTypeProvided;
	private String ssvfOtherService;

	public ClientEnrollmentServiceVO() {
		super();
	}
	public ClientEnrollmentServiceVO(Long enrollmentId) {
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
