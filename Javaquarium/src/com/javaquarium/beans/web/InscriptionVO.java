package com.javaquarium.beans.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * 
 * @author alex
 *
 */

public class InscriptionVO extends ActionForm{

	private static final long serialVersionUID = 1L;
	
	private String utilisateur;
	private String motDePasse;

	public String getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur
	 *            the utilisateur to set
	 */
	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse
	 *            the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		final ActionErrors errors = new ActionErrors();

		if (StringUtils.isEmpty(getUtilisateur())) {
			errors.add("utilisateur", new ActionMessage("errors.inscription.field.nom", "Non d'utilisateur"));
		}

		if (StringUtils.isEmpty(getMotDePasse())) {
			errors.add("motDePasse", new ActionMessage("errors.inscription.field.password", "Mot de passe"));
		}
		
		if (StringUtils.length(getUtilisateur()) < 4) {
			errors.add("utilistaeur", new ActionMessage("errors.inscription.field.nom_2", "Utilisateur"));
		}

		if (StringUtils.length(getMotDePasse()) < 4) {
			errors.add("motDePasse", new ActionMessage("errors.field.minlength", "Mot de passe"));
		}
		
		request.getSession().setAttribute("utilisateur", this);
		
		return errors;
	}
	
	
}
