package org.openhmis.service;

import java.util.List;

import org.openhmis.domain.CodeGender;
import org.openhmis.exception.gender.GenderAlreadyExistException;
import org.openhmis.exception.gender.GenderNotFoundException;

public interface GenderManager 
{
	public Boolean addGender(CodeGender gender) throws GenderAlreadyExistException;
	public List<Object[]> getGenderCodes()throws GenderNotFoundException;															// array of all the gender codes
	public List<CodeGender> getGenders() throws GenderNotFoundException;															// list of all the gender objects
}
