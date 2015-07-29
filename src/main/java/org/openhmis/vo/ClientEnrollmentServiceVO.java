package org.openhmis.vo;
import java.util.Date;
import org.openhmis.code.ClientHopwaServices;
import org.openhmis.code.ClientPathServices;
import org.openhmis.code.ClientRhyServices;
import org.openhmis.code.ClientSsvfServices;
import org.openhmis.code.ClientSsvfSubType3;
import org.openhmis.code.ClientSsvfSubType4;
import org.openhmis.code.ClientSsvfSubType5;


public class ClientEnrollmentServiceVO {
	private Long serviceId;
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

	public ClientEnrollmentServiceVO() {}
}
