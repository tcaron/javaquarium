package com.javaquarium.dao;


import org.hibernate.Query;
import org.hibernate.Session;

import com.javaquarium.beans.data.UtilisateurDO;
import com.javaquarium.util.HibernateUtils;

public class UtilisateurDAO implements IUtilisateurDAO {

	@Override
	public boolean Search(String utilisateur, String motdepasse) {

		final Session session = HibernateUtils.getSession();
		
		UtilisateurDO utilisateurDO = null;
		
		try {
			
			final Query req = session.createQuery("from UtilistaeurDO where utilisateur= :user and motdepasse= :password");
			
			req.setString("user",utilisateur);
			req.setString("password",motdepasse);
			
			utilisateurDO = (UtilisateurDO) req.uniqueResult();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			session.close();
		}
		
		return utilisateurDO != null;
	}
	
}
	
