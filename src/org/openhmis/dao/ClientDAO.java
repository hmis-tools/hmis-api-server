package org.openhmis.dao;

import java.util.List;

import org.openhmis.domain.Client;

public interface ClientDAO extends BaseDAO
{
        public Boolean validateClient(Client client);
        public Client findClient(Client client);
        public Client findClientById(Integer clientKey);
        public List<Client> findClientByName(String firstName, String lastName);
        public List<Client> findClientByLastName(String lastName);
        public Client findClientBySSN(String ssn);
}