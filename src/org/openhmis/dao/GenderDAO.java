package org.openhmis.dao;

import java.util.List;

import org.openhmis.domain.Gender;

public interface GenderDAO extends BaseDAO
{
        public List<Object[]> findGenderCodes();
        public List<Gender> findGenders();
}

