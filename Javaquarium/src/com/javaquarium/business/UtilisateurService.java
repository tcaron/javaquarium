package com.javaquarium.business;

import com.javaquarium.beans.data.UtilisateurDO;
import com.javaquarium.beans.web.InscriptionVO;
import com.javaquarium.dao.IUtilisateurDAO;

public class UtilisateurService implements IUtilisateurService {

	private IUtilisateurDAO utilisateurDAO;
	
	@Override
	public void save(InscriptionVO inscriptionvo) {
	
		final UtilisateurDO utilisateurDO = map(inscriptionvo);
		
		utilisateurDAO.insert(utilisateurDO);
		
	}

	
	private UtilisateurDO map(InscriptionVO inscriptionvo) {

			final UtilisateurDO utilisateurDO = new UtilisateurDO();
			
			utilisateurDO.setUtilisateur(inscriptionvo.getUtilisateur());
			utilisateurDO.setPassword(inscriptionvo.getMotDePasse());
			
			return utilisateurDO;
	}


	/**
	 * setter UtilisateurDAO
	 * 
	 * @param utilisateurDAO
	 */
	public void SetUtilisateurDAO(IUtilisateurDAO utilisateurDAO){
		this.utilisateurDAO = utilisateurDAO;
	}
	
	
}
