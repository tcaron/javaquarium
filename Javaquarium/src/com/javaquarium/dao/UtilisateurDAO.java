package com.javaquarium.dao;


import org.hibernate.Query;
import org.hibernate.Session;

import com.javaquarium.beans.data.UtilisateurDO;
import com.javaquarium.util.HibernateUtils;

public class UtilisateurDAO implements IUtilisateurDAO {

	

	@Override
	public boolean Search(String utilisateur, String motDePasse, String motDepasse2) {
		
final Session session = HibernateUtils.getSession();
		
		UtilisateurDO utilisateurDO = null;
		
		try {
			
			final Query req = session.createQuery("from UtilistaeurDO where utilisateur= :utilisateur and motDePasse= :motdepasse and motDePasse2 = :verification_motdepasse");
			
			req.setString("utilisateur",utilisateur);
			req.setString("motdepasse",motDePasse);
			req.setString("verification_motdepasse",motDepasse2);
			
			utilisateurDO = (UtilisateurDO) req.uniqueResult();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			session.close();
		}
		
		return utilisateurDO != null;
	}
	
}
	
