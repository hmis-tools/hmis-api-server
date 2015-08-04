package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpProjectInventory;

public class TmpProjectInventoryDAO extends BaseDAO {

	// default constructor
	public TmpProjectInventoryDAO() { }

	public TmpProjectInventory getTmpProjectInventoryByInventoryId(Integer inventoryId)  {
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
	public List<TmpProjectInventory> getTmpProjectInventoriesByProjectCoCId(Integer projectCoCId) {
		String queryString = "select projectInventory " + 
				"from TmpProjectInventory as projectInventory" + 
				"where projectInventory.projectCoCId =:projectCoCId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("projectCoCId", projectCoCId);
		List<TmpProjectInventory> results = queryObject.list();
		session.close();
		return results;
	}
}