package org.openhmis.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpProjectInventory;
import org.openhmis.dto.search.InventorySearchDTO;
import org.openhmis.util.DateParser;

public class TmpProjectInventoryDAO extends BaseDAO {

	// default constructor
	public TmpProjectInventoryDAO() { }

	public TmpProjectInventory getTmpProjectInventoryById(Integer inventoryId)  {
		String queryString = "select projectInventory " + 
			"from TmpProjectInventory as projectInventory " + 
			"where projectInventory.inventoryId =:inventoryId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("inventoryId", inventoryId);
		queryObject.setMaxResults(1);
		
		List<TmpProjectInventory> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpProjectInventory)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpProjectInventory> getTmpProjectInventories(InventorySearchDTO searchDTO) {

		Session session = getSession();
                Criteria query =  session.createCriteria(TmpProjectInventory.class);
                if(searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("dateUpdated", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
		List<TmpProjectInventory> results = query.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpProjectInventory> getTmpProjectInventories(Date updateDate) {
		String queryString = "select projectInventory " + 
				"from TmpProjectInventory as projectInventory " + 
				"where projectInventory.updateDate >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpProjectInventory> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpProjectInventory> getTmpProjectInventoriesByProjectCoCId(Integer projectCoCid) {
		String queryString = "select projectInventory " + 
				"from TmpProjectInventory as projectInventory " + 
				"where projectInventory.projectCoCid =:projectCoCid";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("projectCoCid", projectCoCid);
		List<TmpProjectInventory> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpProjectInventory> getTmpProjectInventoriesByProjectCoCId(Integer projectCoCid, Date updateDate) {
		String queryString = "select projectInventory " + 
				"from TmpProjectInventory as projectInventory " + 
				"where projectInventory.projectCoCid =:projectCoCid " + 
				"  and projectInventory.updateDate >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("projectCoCid", projectCoCid);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpProjectInventory> results = queryObject.list();
		session.close();
		return results;
	}
}
