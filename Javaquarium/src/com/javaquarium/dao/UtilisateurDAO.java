package com.javaquarium.dao;
import com.javaquarium.beans.data.UtilisateurDO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.javaquarium.util.HibernateUtils;



public class UtilisateurDAO implements IUtilisateurDAO {

	@Override
	public void insert(UtilisateurDO utilisateur) {
		
		final Session s = HibernateUtils.getSession();
		
		try{
			
			final Transaction t = (Transaction) s.beginTransaction();
			s.save(utilisateur);
			t.commit();
			
		}
		
		finally {
			
			s.close();
		}
		
	}


}
	
