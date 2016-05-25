package org.openhmis.manager;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import org.openhmis.code.ClientDobDataQuality;
import org.openhmis.code.ClientEthnicity;
import org.openhmis.code.ClientGender;
import org.openhmis.code.ClientNameDataQuality;
import org.openhmis.code.ClientSsnDataQuality;
import org.openhmis.code.None;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;
import org.openhmis.dao.PathClientDAO;
import org.openhmis.dao.PathClientRaceDAO;
import org.openhmis.dao.PathClientVeteranInfoDAO;
import org.openhmis.domain.PathClient;
import org.openhmis.domain.PathClientRace;
import org.openhmis.dto.ClientDTO;
import org.openhmis.dto.search.ClientSearchDTO;
import org.openhmis.exception.InvalidParameterException;
import org.openhmis.test.UnitTest;

@Category(UnitTest.class)
public class ClientManagerTest {

	private ClientManager clientManager;
	
	/**********
	 * Data Access Tests
	 */

	@Test
	public void aClientCanBeRetrievedByPersonalId() {
		// Set up mocked objects
		PathClientDAO mockPathClientDAO = Mockito.mock(PathClientDAO.class);
		PathClientRaceDAO mockPathClientRaceDAO = Mockito.mock(PathClientRaceDAO.class);
		PathClientVeteranInfoDAO mockPathClientVeteranInfoDAO = Mockito.mock(PathClientVeteranInfoDAO.class);
		
		PathClient pathClient = new PathClient();
		pathClient.setFirstName("John");
		Mockito.when(mockPathClientDAO.getPathClientByClientKey(1)).thenReturn(pathClient);
		
		// Run the test
		ClientManager clientManager = new ClientManager(mockPathClientDAO, mockPathClientRaceDAO, mockPathClientVeteranInfoDAO);
		ClientDTO clientDTO = clientManager.getClientByPersonalId("1");
		assertEquals("John", clientDTO.getFirstName());
	}

	@Test
	public void aListOfAllClientsCanBeRetrieved() {
		// Set up mocked objects
		PathClientDAO mockPathClientDAO = Mockito.mock(PathClientDAO.class);
		PathClientRaceDAO mockPathClientRaceDAO = Mockito.mock(PathClientRaceDAO.class);
		PathClientVeteranInfoDAO mockPathClientVeteranInfoDAO = Mockito.mock(PathClientVeteranInfoDAO.class);
		ClientSearchDTO mockSearchDTO = Mockito.mock(ClientSearchDTO.class);

		PathClient pathClient1 = new PathClient();
		pathClient1.setFirstName("John");
		PathClient pathClient2 = new PathClient();
		pathClient2.setFirstName("Jane");
		ArrayList<PathClient> mockClientList = new ArrayList<PathClient>();
		mockClientList.add(pathClient1);
		mockClientList.add(pathClient2);
		
		Mockito.when(mockPathClientDAO.getPathClients(mockSearchDTO)).thenReturn(mockClientList);
		
		// Run the test
		ClientManager clientManager = new ClientManager(mockPathClientDAO, mockPathClientRaceDAO, mockPathClientVeteranInfoDAO);
		List<ClientDTO> clientDTOs = clientManager.getClients(mockSearchDTO);
		assertEquals(2, clientDTOs.size());
	}
	
	/**********
	 * DTO Generation Tests
	 */
	
	// Primary Key
	@Test
	public void generateClientDTOPreservesClientKey() {
		PathClient pathClient = new PathClient();
		pathClient.setClientKey(42);
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(pathClient.getClientKey().toString(), clientDTO.getPersonalId());
	}
	
	// 3.1: Name
	@Test
	public void generateClientDTOPreservesFirstName() {
		PathClient pathClient = new PathClient();
		pathClient.setFirstName("John");
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals("John", clientDTO.getFirstName());
	}
	
	@Test
	public void generateClientDTOPreservesMiddleName() {
		PathClient pathClient = new PathClient();
		pathClient.setMiddleName("Johnny");
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals("Johnny", clientDTO.getMiddleName());
	}
	
	@Test
	public void generateClientDTOPreservesLastName() {
		PathClient pathClient = new PathClient();
		pathClient.setLastName("Johnson");
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals("Johnson", clientDTO.getLastName());
	}
	
	@Test
	public void generateClientDTOPreservesNameSuffix() {
		PathClient pathClient = new PathClient();
		pathClient.setSuffix("Jhn");
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals("Jhn", clientDTO.getNameSuffix());
	}
	
	@Test
	public void generateClientDTOPreservesNameDataQuality() {
		PathClient pathClient = new PathClient();
		pathClient.setNameType(ClientNameDataQuality.FULL.getCode());
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(ClientNameDataQuality.FULL, clientDTO.getNameDataQuality());
	}
	
	// 3.2 Ssn
	@Test
	public void generateClientDTOPreservesSsn() {
		PathClient pathClient = new PathClient();
		pathClient.setIdentification("123456789");
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals("123456789", clientDTO.getSsn());
	}
	@Test
	public void generateClientDTOPreservesSsnDataQuality() {
		PathClient pathClient = new PathClient();
		pathClient.setIdType(ClientSsnDataQuality.FULL.getCode());
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(ClientSsnDataQuality.FULL, clientDTO.getSsnDataQuality());
	}
	
	// 3.3 Date of Birth
	@Test
	public void generateClientDTOPreservesDoB() {
		PathClient pathClient = new PathClient();
		Date birthday = new Date();
		pathClient.setDateOfBirth(birthday);
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(birthday, clientDTO.getDob());
	}
	
	@Test
	public void generateClientDTOPreservesDobDataQuality() {
		PathClient pathClient = new PathClient();
		pathClient.setDobType(ClientDobDataQuality.FULL.getCode());
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(ClientDobDataQuality.FULL, clientDTO.getDobDataQuality());
	}
	
	// 3.4 Races
	@Test
	public void generateClientDTOSetsRaceNoneToNotCollectedWithNullRacesList() {
		PathClient pathClient = new PathClient();
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(None.NOT_COLLECTED, clientDTO.getRaceNone());
	}

	@Test
	public void generateClientDTOSetsRaceNoneToNotCollectedWithEmptyRacesList() {
		PathClient pathClient = new PathClient();
		ArrayList<PathClientRace> pathClientRaces = new ArrayList<PathClientRace>();
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, pathClientRaces, null);
		assertEquals(None.NOT_COLLECTED, clientDTO.getRaceNone());
	}
	
	@Test
	public void generateClientDTOPreservesAsianRace() {
		PathClient pathClient = new PathClient();
		ArrayList<PathClientRace> pathClientRaces = new ArrayList<PathClientRace>();
		PathClientRace pathClientRace = new PathClientRace();
		pathClientRace.setRaceKey(5); // Compass stores races as special codes, currently hardcoded.
		pathClientRaces.add(pathClientRace);
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, pathClientRaces, null);
		assertEquals(YesNo.YES, clientDTO.getAsian());
	}
	
	@Test
	public void generateClientDTOPreservesBlackAfAmericanRace() {
		PathClient pathClient = new PathClient();
		ArrayList<PathClientRace> pathClientRaces = new ArrayList<PathClientRace>();
		PathClientRace pathClientRace = new PathClientRace();
		pathClientRace.setRaceKey(6); // Compass stores races as special codes, currently hardcoded.
		pathClientRaces.add(pathClientRace);
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, pathClientRaces, null);
		assertEquals(YesNo.YES, clientDTO.getBlackAfAmerican());
	}

	@Test
	public void generateClientDTOPreservesAmIndAKNativeRace() {
		PathClient pathClient = new PathClient();
		ArrayList<PathClientRace> pathClientRaces = new ArrayList<PathClientRace>();
		PathClientRace pathClientRace = new PathClientRace();
		pathClientRace.setRaceKey(7); // Compass stores races as special codes, currently hardcoded.
		pathClientRaces.add(pathClientRace);
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, pathClientRaces, null);
		assertEquals(YesNo.YES, clientDTO.getAmIndAKNative());
	}

	@Test
	public void generateClientDTOPreservesWhiteRace() {
		PathClient pathClient = new PathClient();
		ArrayList<PathClientRace> pathClientRaces = new ArrayList<PathClientRace>();
		PathClientRace pathClientRace = new PathClientRace();
		pathClientRace.setRaceKey(8); // Compass stores races as special codes, currently hardcoded.
		pathClientRaces.add(pathClientRace);
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, pathClientRaces, null);
		assertEquals(YesNo.YES, clientDTO.getWhite());
	}
	
	@Test
	public void generateClientDTOPreservesNativeHIOtherPacificRace() {
		PathClient pathClient = new PathClient();
		ArrayList<PathClientRace> pathClientRaces = new ArrayList<PathClientRace>();
		PathClientRace pathClientRace = new PathClientRace();
		pathClientRace.setRaceKey(9); // Compass stores races as special codes, currently hardcoded.
		pathClientRaces.add(pathClientRace);
		
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, pathClientRaces, null);
		assertEquals(YesNo.YES, clientDTO.getNativeHIOtherPacific());
	}
	
	@Test
	public void generateClientDTOSetsExactlyTheRacesProvided() {
		PathClient pathClient = new PathClient();
		ArrayList<PathClientRace> pathClientRaces = new ArrayList<PathClientRace>();
		PathClientRace pathClientAsianRace = new PathClientRace();
		PathClientRace pathClientBlackAfAmericanRace = new PathClientRace();
		pathClientAsianRace.setRaceKey(5); // Compass stores races as special codes, currently hardcoded.
		pathClientBlackAfAmericanRace.setRaceKey(6); // Compass stores races as special codes, currently hardcoded.
		pathClientRaces.add(pathClientAsianRace);
		pathClientRaces.add(pathClientBlackAfAmericanRace);
		
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, pathClientRaces, null);
		assertEquals(YesNo.YES, clientDTO.getAsian());
		assertEquals(YesNo.YES, clientDTO.getBlackAfAmerican());
		assertEquals(YesNo.NO, clientDTO.getAmIndAKNative());
		assertEquals(YesNo.NO, clientDTO.getWhite());
		assertEquals(YesNo.NO, clientDTO.getNativeHIOtherPacific());
	}

	@Test
	public void generateClientDTOSetsRaceNoneToNullWhenRacesAreProvided() {
		PathClient pathClient = new PathClient();
		ArrayList<PathClientRace> pathClientRaces = new ArrayList<PathClientRace>();
		PathClientRace pathClientRace = new PathClientRace();
		pathClientRace.setRaceKey(5); // Compass stores races as special codes, currently hardcoded.
		pathClientRaces.add(pathClientRace);
		
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, pathClientRaces, null);
		assertEquals(null, clientDTO.getRaceNone());
	}
	
	// 3.5 Ethnicity
	@Test
	public void generateClientDTOPreservesEthnicity() {
		PathClient pathClient = new PathClient();
		pathClient.setEthnicityKey(ClientEthnicity.REFUSED.getCode());
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(ClientEthnicity.REFUSED, clientDTO.getEthnicity());
	}
	
	// 3.6 Gender
	@Test
	public void generateClientDTOPreservesGender() {
		PathClient pathClient = new PathClient();
		pathClient.setGenderKey(ClientGender.MALE.getCode());
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(ClientGender.MALE, clientDTO.getGender());
	}

	@Test
	public void generateClientDTOPreservesOtherGender() {
		PathClient pathClient = new PathClient();
		pathClient.setGenderDesc("Other Description");
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals("Other Description", clientDTO.getOtherGender());
	}
	
	// 3.7 Veteran Status
	@Test
	public void generateClientDTOPreservesVeteranStatus() {
		PathClient pathClient = new PathClient();
		pathClient.setVeteran(YesNoReason.YES.getCode());
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(YesNoReason.YES, clientDTO.getVeteranStatus());
	}	
	

	/**********
	 * Validation Tests
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	// 3.1 (Name)
	@Test
	public void validationRejectsUnknownCodeForNameDataQality() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setNameDataQuality(ClientNameDataQuality.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		ClientManager.validateClient(clientDTO);
	}
	
	// 3.2 (SSN)
	@Test
	public void validationRejectsUnknownCodeForSsnDataQality() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setSsnDataQuality(ClientSsnDataQuality.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		ClientManager.validateClient(clientDTO);
	}

	@Test
	public void validationRejectsSsnContainingLetters() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setSsn("12345678a");

		thrown.expect(InvalidParameterException.class);
		ClientManager.validateClient(clientDTO);
	}
	
	@Test
	public void validationRejectsSsnContainingTooManyCharacters() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setSsn("1234567891");

		thrown.expect(InvalidParameterException.class);
		ClientManager.validateClient(clientDTO);
	}

	@Test
	public void validationRejectsSsnContainingTooFewCharacters() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setSsn("12345678");

		thrown.expect(InvalidParameterException.class);
		ClientManager.validateClient(clientDTO);
	}

	@Test
	public void validationAcceptsSsnContainingXs() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setSsn("xxXxx3xx3");
		Boolean result = ClientManager.validateClient(clientDTO);
		assertEquals(true, result);
	}
	
	@Test
	public void validationAcceptsSsnContainingNineCharacters() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setSsn("123456789");
		Boolean result = ClientManager.validateClient(clientDTO);
		assertEquals(true, result);
	}
	
	// 3.3 DoB
	@Test
	public void validationRejectsBirthdayFromFuture() {
		ClientDTO clientDTO = new ClientDTO();
		
	    Calendar calendar = Calendar.getInstance();
	    calendar.add(Calendar.DAY_OF_YEAR, 1);
	    Date tomorrow = calendar.getTime();
		clientDTO.setDob(tomorrow);
		
		thrown.expect(InvalidParameterException.class);
		ClientManager.validateClient(clientDTO);
	}	
	
	@Test
	public void validationRejectsUnknownCodeForDobDataQality() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setDobDataQuality(ClientDobDataQuality.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		ClientManager.validateClient(clientDTO);
	}
	
	// 3.4 Race
	@Test
	public void validationRejectsUnknownCodeForAsian() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setAsian(YesNo.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		ClientManager.validateClient(clientDTO);
	}

	@Test
	public void validationRejectsUnknownCodeForBlackAfAmerican() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setBlackAfAmerican(YesNo.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		ClientManager.validateClient(clientDTO);
	}

	@Test
	public void validationRejectsUnknownCodeForNativeHIOtherPacific() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setNativeHIOtherPacific(YesNo.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		ClientManager.validateClient(clientDTO);
	}

	@Test
	public void validationRejectsUnknownCodeForAmIndAKNative() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setAmIndAKNative(YesNo.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		ClientManager.validateClient(clientDTO);
	}

	@Test
	public void validationRejectsUnknownCodeForWhite() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setWhite(YesNo.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		ClientManager.validateClient(clientDTO);
	}

	@Test
	public void validationRejectsRaceNoneValueWithRaceSet() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setAsian(YesNo.YES);
		clientDTO.setRaceNone(None.REFUSED);
		
		thrown.expect(InvalidParameterException.class);
		ClientManager.validateClient(clientDTO);
	}

	@Test
	public void validationRejectsUnknownCodeForRaceNone() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setRaceNone(None.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		ClientManager.validateClient(clientDTO);
	}

	// 3.5 Ethnicity
	@Test
	public void validationRejectsUnknownCodeForEthnicity() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setEthnicity(ClientEthnicity.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		ClientManager.validateClient(clientDTO);
	}

	// 3.6 Gender
	@Test
	public void validationRejectsUnknownCodeForGender() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setGender(ClientGender.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		ClientManager.validateClient(clientDTO);
	}

	// 3.7 Veteran Status
	@Test
	public void validationRejectsUnknownCodeForVeteranStatus() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setVeteranStatus(YesNoReason.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		ClientManager.validateClient(clientDTO);
	}	
}