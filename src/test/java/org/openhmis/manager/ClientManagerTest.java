package org.openhmis.manager;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.openhmis.code.ClientDobDataQuality;
import org.openhmis.code.ClientEthnicity;
import org.openhmis.code.ClientGender;
import org.openhmis.code.ClientNameDataQuality;
import org.openhmis.code.ClientSsnDataQuality;
import org.openhmis.code.None;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;
import org.openhmis.domain.PathClient;
import org.openhmis.domain.PathClientRace;
import org.openhmis.dto.ClientDTO;
import org.openhmis.exception.InvalidParameterException;
import org.openhmis.test.UnitTest;

@Category(UnitTest.class)
public class ClientManagerTest {

	private ClientManager clientManager;
	
	@Before
	public void setUp() {
		this.clientManager = new ClientManager();
	}

	@After
	public void tearDown() {
		this.clientManager = null;
	}
	
	/**********
	 * DTO Generation Tests
	 **********/
	
	// Primary Key
	@Test
	public void generateClientDTOPreservesClientKey() {
		PathClient pathClient = new PathClient();
		pathClient.setClientKey(42);
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(clientDTO.getPersonalId(), pathClient.getClientKey().toString());
	}
	
	// 3.1: Name
	@Test
	public void generateClientDTOPreservesFirstName() {
		PathClient pathClient = new PathClient();
		pathClient.setFirstName("John");
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(clientDTO.getFirstName(), pathClient.getFirstName());
	}
	
	@Test
	public void generateClientDTOPreservesMiddleName() {
		PathClient pathClient = new PathClient();
		pathClient.setMiddleName("Johnny");
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(clientDTO.getMiddleName(), pathClient.getMiddleName());
	}
	
	@Test
	public void generateClientDTOPreservesLastName() {
		PathClient pathClient = new PathClient();
		pathClient.setLastName("Johnson");
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(clientDTO.getLastName(), pathClient.getLastName());
	}
	
	@Test
	public void generateClientDTOPreservesNameSuffix() {
		PathClient pathClient = new PathClient();
		pathClient.setSuffix("Jhn");
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(clientDTO.getNameSuffix(), pathClient.getSuffix());
	}
	
	@Test
	public void generateClientDTOPreservesNameDataQuality() {
		PathClient pathClient = new PathClient();
		pathClient.setNameType(ClientNameDataQuality.FULL.getCode());
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(clientDTO.getNameDataQuality().getCode(), pathClient.getNameType());
	}
	
	// 3.2 Ssn
	@Test
	public void generateClientDTOPreservesSsn() {
		PathClient pathClient = new PathClient();
		pathClient.setIdentification("123456789");
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(clientDTO.getSsn(), pathClient.getIdentification());
	}
	@Test
	public void generateClientDTOPreservesSsnDataQuality() {
		PathClient pathClient = new PathClient();
		pathClient.setIdType(ClientSsnDataQuality.FULL.getCode());
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(clientDTO.getSsnDataQuality().getCode(), pathClient.getIdType());
	}
	
	// 3.3 Date of Birth
	@Test
	public void generateClientDTOPreservesDoB() {
		PathClient pathClient = new PathClient();
		pathClient.setDateOfBirth(new Date());
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(clientDTO.getDob(), pathClient.getDateOfBirth());
	}
	
	@Test
	public void generateClientDTOPreservesDobDataQuality() {
		PathClient pathClient = new PathClient();
		pathClient.setDobType(ClientDobDataQuality.FULL.getCode());
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(clientDTO.getDobDataQuality().getCode(), pathClient.getDobType());
	}
	
	// 3.4 Races
	@Test
	public void generateClientDTOSetsRaceNoneToNotCollectedWithNullRacesList() {
		PathClient pathClient = new PathClient();
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(clientDTO.getRaceNone(), None.NOT_COLLECTED);
	}

	@Test
	public void generateClientDTOSetsRaceNoneToNotCollectedWithEmptyRacesList() {
		PathClient pathClient = new PathClient();
		ArrayList<PathClientRace> pathClientRaces = new ArrayList<PathClientRace>();
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, pathClientRaces, null);
		assertEquals(clientDTO.getRaceNone(), None.NOT_COLLECTED);
	}
	
	@Test
	public void generateClientDTOPreservesAsianRace() {
		PathClient pathClient = new PathClient();
		ArrayList<PathClientRace> pathClientRaces = new ArrayList<PathClientRace>();
		PathClientRace pathClientRace = new PathClientRace();
		pathClientRace.setRaceKey(5); // Compass stores races as special codes, currently hardcoded.
		pathClientRaces.add(pathClientRace);
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, pathClientRaces, null);
		assertEquals(clientDTO.getAsian(), YesNo.YES);
	}
	
	@Test
	public void generateClientDTOPreservesBlackAfAmericanRace() {
		PathClient pathClient = new PathClient();
		ArrayList<PathClientRace> pathClientRaces = new ArrayList<PathClientRace>();
		PathClientRace pathClientRace = new PathClientRace();
		pathClientRace.setRaceKey(6); // Compass stores races as special codes, currently hardcoded.
		pathClientRaces.add(pathClientRace);
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, pathClientRaces, null);
		assertEquals(clientDTO.getBlackAfAmerican(), YesNo.YES);
	}

	@Test
	public void generateClientDTOPreservesAmIndAKNativeRace() {
		PathClient pathClient = new PathClient();
		ArrayList<PathClientRace> pathClientRaces = new ArrayList<PathClientRace>();
		PathClientRace pathClientRace = new PathClientRace();
		pathClientRace.setRaceKey(7); // Compass stores races as special codes, currently hardcoded.
		pathClientRaces.add(pathClientRace);
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, pathClientRaces, null);
		assertEquals(clientDTO.getAmIndAKNative(), YesNo.YES);
	}

	@Test
	public void generateClientDTOPreservesWhiteRace() {
		PathClient pathClient = new PathClient();
		ArrayList<PathClientRace> pathClientRaces = new ArrayList<PathClientRace>();
		PathClientRace pathClientRace = new PathClientRace();
		pathClientRace.setRaceKey(8); // Compass stores races as special codes, currently hardcoded.
		pathClientRaces.add(pathClientRace);
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, pathClientRaces, null);
		assertEquals(clientDTO.getWhite(), YesNo.YES);
	}
	
	@Test
	public void generateClientDTOPreservesNativeHIOtherPacificRace() {
		PathClient pathClient = new PathClient();
		ArrayList<PathClientRace> pathClientRaces = new ArrayList<PathClientRace>();
		PathClientRace pathClientRace = new PathClientRace();
		pathClientRace.setRaceKey(9); // Compass stores races as special codes, currently hardcoded.
		pathClientRaces.add(pathClientRace);
		
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, pathClientRaces, null);
		assertEquals(clientDTO.getNativeHIOtherPacific(), YesNo.YES);
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
		assertEquals(clientDTO.getAsian(), YesNo.YES);
		assertEquals(clientDTO.getBlackAfAmerican(), YesNo.YES);
		assertEquals(clientDTO.getAmIndAKNative(), YesNo.NO);
		assertEquals(clientDTO.getWhite(), YesNo.NO);
		assertEquals(clientDTO.getNativeHIOtherPacific(), YesNo.NO);
	}

	@Test
	public void generateClientDTOSetsRaceNoneToNullWhenRacesAreProvided() {
		PathClient pathClient = new PathClient();
		ArrayList<PathClientRace> pathClientRaces = new ArrayList<PathClientRace>();
		PathClientRace pathClientRace = new PathClientRace();
		pathClientRace.setRaceKey(5); // Compass stores races as special codes, currently hardcoded.
		pathClientRaces.add(pathClientRace);
		
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, pathClientRaces, null);
		assertEquals(clientDTO.getRaceNone(), null);
	}
	
	// 3.5 Ethnicity
	@Test
	public void generateClientDTOPreservesEthnicity() {
		PathClient pathClient = new PathClient();
		pathClient.setEthnicityKey(ClientEthnicity.REFUSED.getCode());
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(clientDTO.getEthnicity().getCode(), pathClient.getEthnicityKey());
	}
	
	// 3.6 Gender
	@Test
	public void generateClientDTOPreservesGender() {
		PathClient pathClient = new PathClient();
		pathClient.setGenderKey(ClientGender.MALE.getCode());
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(clientDTO.getGender().getCode(), pathClient.getGenderKey());
	}

	@Test
	public void generateClientDTOPreservesOtherGender() {
		PathClient pathClient = new PathClient();
		pathClient.setGenderDesc("Other Description");
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(clientDTO.getOtherGender(), pathClient.getGenderDesc());
	}
	
	// 3.7 Veteran Status
	@Test
	public void generateClientDTOPreservesVeteranStatus() {
		PathClient pathClient = new PathClient();
		pathClient.setVeteran(YesNoReason.YES.getCode());
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, null, null);
		assertEquals(clientDTO.getVeteranStatus().getCode(), pathClient.getVeteran());
	}	
	

	/**********
	 * Validation Tests
	 **********/
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	// 3.1 (Name)
	@Test
	public void validationRejectsUnknownCodeForNameDataQality() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setNameDataQuality(ClientNameDataQuality.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		clientManager.validateClient(clientDTO);
	}
	
	// 3.2 (SSN)
	@Test
	public void validationRejectsUnknownCodeForSsnDataQality() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setSsnDataQuality(ClientSsnDataQuality.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		clientManager.validateClient(clientDTO);
	}

	@Test
	public void validationRejectsSsnContainingLetters() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setSsn("12345678a");

		thrown.expect(InvalidParameterException.class);
		clientManager.validateClient(clientDTO);
	}
	
	@Test
	public void validationRejectsSsnContainingTooManyCharacters() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setSsn("1234567891");

		thrown.expect(InvalidParameterException.class);
		clientManager.validateClient(clientDTO);
	}

	@Test
	public void validationRejectsSsnContainingTooFewCharacters() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setSsn("12345678");

		thrown.expect(InvalidParameterException.class);
		clientManager.validateClient(clientDTO);
	}

	@Test
	public void validationAcceptsSsnContainingXs() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setSsn("xxXxx3xx3");
		Boolean result = clientManager.validateClient(clientDTO);
		assertEquals(result, true);
	}
	
	@Test
	public void validationAcceptsSsnContainingNineCharacters() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setSsn("123456789");
		Boolean result = clientManager.validateClient(clientDTO);
		assertEquals(result, true);
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
		clientManager.validateClient(clientDTO);
	}	
	
	@Test
	public void validationRejectsUnknownCodeForDobDataQality() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setDobDataQuality(ClientDobDataQuality.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		clientManager.validateClient(clientDTO);
	}
	
	// 3.4 Race
	@Test
	public void validationRejectsUnknownCodeForAsian() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setAsian(YesNo.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		clientManager.validateClient(clientDTO);
	}

	@Test
	public void validationRejectsUnknownCodeForBlackAfAmerican() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setBlackAfAmerican(YesNo.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		clientManager.validateClient(clientDTO);
	}

	@Test
	public void validationRejectsUnknownCodeForNativeHIOtherPacific() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setNativeHIOtherPacific(YesNo.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		clientManager.validateClient(clientDTO);
	}

	@Test
	public void validationRejectsUnknownCodeForAmIndAKNative() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setAmIndAKNative(YesNo.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		clientManager.validateClient(clientDTO);
	}

	@Test
	public void validationRejectsUnknownCodeForWhite() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setWhite(YesNo.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		clientManager.validateClient(clientDTO);
	}

	@Test
	public void validationRejectsRaceNoneValueWithRaceSet() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setAsian(YesNo.YES);
		clientDTO.setRaceNone(None.REFUSED);
		
		thrown.expect(InvalidParameterException.class);
		clientManager.validateClient(clientDTO);
	}

	@Test
	public void validationRejectsUnknownCodeForRaceNone() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setRaceNone(None.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		clientManager.validateClient(clientDTO);
	}

	// 3.5 Ethnicity
	@Test
	public void validationRejectsUnknownCodeForEthnicity() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setEthnicity(ClientEthnicity.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		clientManager.validateClient(clientDTO);
	}

	// 3.6 Gender
	@Test
	public void validationRejectsUnknownCodeForGender() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setGender(ClientGender.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		clientManager.validateClient(clientDTO);
	}

	// 3.7 Veteran Status
	@Test
	public void validationRejectsUnknownCodeForVeteranStatus() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setVeteranStatus(YesNoReason.ERR_UNKNOWN);
		
		thrown.expect(InvalidParameterException.class);
		clientManager.validateClient(clientDTO);
	}	
}