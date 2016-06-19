package org.openhmis.manager;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import org.openhmis.dao.PathClientDAO;
import org.openhmis.dao.PathClientRaceDAO;
import org.openhmis.dao.PathClientVeteranInfoDAO;
import org.openhmis.domain.PathClient;
import org.openhmis.domain.PathClientRace;
import org.openhmis.domain.PathClientVeteranInfo;
import org.openhmis.dto.ClientDTO;
import org.openhmis.dto.search.ClientSearchDTO;
import org.openhmis.exception.InvalidParameterException;
import org.openhmis.manager.ClientManager;

public class ClientManager {

	private PathClientDAO pathClientDAO;
	private PathClientRaceDAO pathClientRaceDAO;
	private PathClientVeteranInfoDAO pathClientVeteranInfoDAO;
	
	public ClientManager() {
		this.pathClientDAO = new PathClientDAO();
		this.pathClientRaceDAO = new PathClientRaceDAO();
		this.pathClientVeteranInfoDAO = new PathClientVeteranInfoDAO();
	}

	public ClientManager(PathClientDAO pathClientDAO, PathClientRaceDAO pathClientRaceDAO, PathClientVeteranInfoDAO pathClientVeteranInfoDAO) {
		this.pathClientDAO = pathClientDAO;
		this.pathClientRaceDAO = pathClientRaceDAO;
		this.pathClientVeteranInfoDAO = pathClientVeteranInfoDAO;
	}

	public ClientDTO getClientByPersonalId(String personalId) {
		Integer clientKey = Integer.parseInt(personalId);
		
		// Collect the data for this client
		PathClient pathClient = pathClientDAO.getPathClientByClientKey(clientKey);
		List<PathClientRace> pathRaces = pathClientRaceDAO.getPathRacesByClientKey(clientKey);
		PathClientVeteranInfo pathVeteranInfo = pathClientVeteranInfoDAO.getPathVeteranInfoByClientKey(clientKey);
		
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, pathRaces, pathVeteranInfo);

		return clientDTO;
	}

	public List<ClientDTO> getClients(ClientSearchDTO searchDTO) {
		List<ClientDTO> clientDTOs = new ArrayList<ClientDTO>();
		
		// Collect the clients
		List<PathClient> pathClients = pathClientDAO.getPathClients(searchDTO);
		
		// For each client, collect and map the data
		// TODO: this should be done in a single query
		for (Iterator<PathClient> iterator = pathClients.iterator(); iterator.hasNext();) {
			PathClient pathClient = iterator.next();
			Integer clientKey = pathClient.getClientKey();
			List<PathClientRace> pathRaces = pathClientRaceDAO.getPathRacesByClientKey(clientKey);
			PathClientVeteranInfo pathVeteranInfo = pathClientVeteranInfoDAO.getPathVeteranInfoByClientKey(clientKey);

			ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, pathRaces, pathVeteranInfo);
			clientDTOs.add(clientDTO);
		}
		
		return clientDTOs;
	}
	
	public ClientDTO addClient(ClientDTO inputDTO) {
		// Validate the client
		if(!ClientManager.validateClient(inputDTO))
			return null;
		
		// Generate a PathClient from the input
		PathClient pathClient = ClientManager.generatePathClient(inputDTO);
		
		// Set Export fields
		pathClient.setUpdateDate(new Date());
		pathClient.setCreateDate(new Date());
		
		// Set Compass Required Fields
		pathClient.setUpdateTimestamp(new Date());

		// Save the client to allow secondary object generation
		pathClientDAO.save(pathClient);
		inputDTO.setPersonalId(pathClient.getClientKey().toString());
		
		// Save the races
		List<PathClientRace> pathRaces = ClientManager.generatePathClientRaces(inputDTO);
		for (Iterator<PathClientRace> iterator = pathRaces.iterator(); iterator.hasNext();) {
			PathClientRace pathRace = iterator.next();
			pathRace.setUpdateTimestamp(new Date());
			pathClientRaceDAO.save(pathRace);
		}

		// Save Veteran Info
		PathClientVeteranInfo pathVeteranInfo = ClientManager.generatePathVeteranInfo(inputDTO);
		pathVeteranInfo.setUpdateTimestamp(new Date());
		pathVeteranInfo.setClientKey(pathClient.getClientKey());
		pathClientVeteranInfoDAO.save(pathVeteranInfo);
		
		// Return the resulting VO
		return ClientManager.generateClientDTO(pathClient, pathRaces, pathVeteranInfo);
	}
	
	public ClientDTO updateClient(ClientDTO inputDTO) {
		// Validate the client
		if(!ClientManager.validateClient(inputDTO))
			return null;

		// Generate a PathClient from the input
		PathClient pathClient = ClientManager.generatePathClient(inputDTO);
		pathClient.setClientKey(Integer.parseInt(inputDTO.getPersonalId()));
		pathClient.setUpdateDate(new Date());
		pathClient.setUpdateTimestamp(new Date());
		
		// Update the client
		pathClientDAO.update(pathClient);

		// Delete old races
		List<PathClientRace> oldPathRaces = pathClientRaceDAO.getPathRacesByClientKey(pathClient.getClientKey());
		for (Iterator<PathClientRace> iterator = oldPathRaces.iterator(); iterator.hasNext();) {
			PathClientRace oldPathRace = iterator.next();
			pathClientRaceDAO.delete(oldPathRace);
		}
		
		// Save new races
		List<PathClientRace> newPathRaces = ClientManager.generatePathClientRaces(inputDTO);
		for (Iterator<PathClientRace> iterator = newPathRaces.iterator(); iterator.hasNext();) {
			PathClientRace newPathRace = iterator.next();
			newPathRace.setUpdateTimestamp(new Date());
			pathClientRaceDAO.save(newPathRace);
		}
		
		// Update Veteran Info
		// NOTE: client key is the primary key, so we don't need to look up any stored values
		PathClientVeteranInfo pathVeteranInfo = ClientManager.generatePathVeteranInfo(inputDTO);
		pathVeteranInfo.setUpdateTimestamp(new Date());
		pathClientVeteranInfoDAO.update(pathVeteranInfo);

		// Return the resulting VO
		return ClientManager.generateClientDTO(pathClient, newPathRaces, pathVeteranInfo);
	}
	
	public boolean deleteClient(String personalId) {
		PathClient pathClient = pathClientDAO.getPathClientByClientKey(Integer.parseInt(personalId));
		pathClientDAO.delete(pathClient);

		// Delete associated races
		List<PathClientRace> pathRaces = pathClientRaceDAO.getPathRacesByClientKey(pathClient.getClientKey());
		for (Iterator<PathClientRace> iterator = pathRaces.iterator(); iterator.hasNext();) {
			PathClientRace pathRace = iterator.next();
			pathClientRaceDAO.delete(pathRace);
		}
		
		// Delete associated veteran info
		PathClientVeteranInfo pathClientVeteranInfo = pathClientVeteranInfoDAO.getPathVeteranInfoByClientKey(pathClient.getClientKey());
		pathClientVeteranInfoDAO.delete(pathClientVeteranInfo);
		
		return true;
	}
}
