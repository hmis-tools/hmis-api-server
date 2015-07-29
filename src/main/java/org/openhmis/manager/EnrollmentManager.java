package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.openhmis.code.ClientDischargeStatus;
import org.openhmis.code.ClientDobDataQuality;
import org.openhmis.code.ClientEthnicity;
import org.openhmis.code.ClientGender;
import org.openhmis.code.ClientMilitaryBranch;
import org.openhmis.code.ClientNameDataQuality;
import org.openhmis.code.ClientSsnDataQuality;
import org.openhmis.code.None;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;
import org.openhmis.dao.PathClientProgramDAO;
import org.openhmis.domain.PathClientProgram;
import org.openhmis.exception.client.ClientNotFoundException;
import org.openhmis.vo.EnrollmentVO;

public class EnrollmentManager {

	private static final PathClientProgramDAO pathClientProgramDAO = new PathClientProgramDAO();
	
	public EnrollmentManager() {}

	public EnrollmentVO getEnrollmentById(String enrollmentId) {
		Integer programKey = Integer.parseInt(enrollmentId);
		
		// Collect the data for this client
		PathClientProgram pathClientProgram = pathClientProgramDAO.getPathClientProgramByProgramKey(programKey);
		
		EnrollmentVO enrollmentVO = EnrollmentManager.generateEnrollmentVO(pathClientProgram);

		return enrollmentVO;
	}

	public List<EnrollmentVO> getEnrollments() {
		List<EnrollmentVO> enrollmentVOs = new ArrayList<EnrollmentVO>();
		
		// Collect the clients
		//List<PathClient> clients = clientDAO.getClients();
		
		// For each client, collect and map the data
		// TODO: this should be done in a single query
		// for (Iterator<PathClient> iterator = clients.iterator(); iterator.hasNext();) {
		// 	PathClient client = iterator.next();
		// 	Integer clientKey = client.getClientKey();
		// 	List<PathClientRace> races = clientRaceDAO.getRacesByClientKey(clientKey);
		// 	PathClientVeteranInfo veteranInfo = clientVeteranInfoDAO.getVeteranInfoByClientKey(clientKey);

		// 	ClientVO clientVO = ClientManager.generateClientVO(client, races, veteranInfo);
		// 	clientVOs.add(clientVO);
		// }
		
		return enrollmentVOs;
	}
	
	public EnrollmentVO addEnrollment(EnrollmentVO inputVO) {
		
		// Generate a PathClient from the input
		//PathClient client = ClientManager.generatePathClient(inputVO);
		
		// Return the resulting VO
		return new EnrollmentVO();
	}
	
	public EnrollmentVO updateEnrollment(EnrollmentVO inputVO) {
		
		
		// Return the resulting VO
		return new EnrollmentVO();
	}
	
	public boolean deleteEnrollment(String enrollmentId) {
		return false;
	}
	
	public static EnrollmentVO generateEnrollmentVO(PathClientProgram pathClientProgram) {
		EnrollmentVO enrollmentVO = new EnrollmentVO();
		
		return enrollmentVO;
	}
	
	public static PathClientProgram generatePathClientProgram(EnrollmentVO enrollmentVO) {
		return new PathClientProgram();
	}	
	
}