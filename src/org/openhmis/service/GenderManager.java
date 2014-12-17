package org.openhmis.service;

import java.util.List;

import org.openhmis.domain.Gender;
import org.openhmis.exception.gender.GenderAlreadyExistException;
import org.openhmis.exception.gender.GenderNotFoundException;

public interface GenderManager 
{
	public Boolean addGender(Gender gender) throws GenderAlreadyExistException;
	public List<Object[]> getGenderCodes()throws GenderNotFoundException;															// array of all the gender codes
	public List<Gender> getGenders() throws GenderNotFoundException;															// list of all the gender objects
}
