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
	private String motDePasse2;
	private String email;
	private String naissance;
	
	
	
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
	
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the naissance
	 */
	
	public String getNaissance() {
		return naissance;
	}

	/**
	 * @param naissance
	 *            the naissance to set
	 */
	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}
	
	/**
	 * @return the motDePasse2
	 */
	public String getVerifPassword() {
		return motDePasse2;
	}

	/**
	 * @param motDePasse2
	 *            the motDePasse2 to set
	 */
	public void setVerifPassword(String motDePasse2) {
		this.motDePasse2 = motDePasse2;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		final ActionErrors errors = new ActionErrors();

		if (StringUtils.isEmpty(getUtilisateur())) {
			errors.add("utilisateur", new ActionMessage("errors.inscription.field.nom", "Non d'utilisateur"));
		}

		if (StringUtils.isEmpty(getMotDePasse())) {
			errors.add("password1", new ActionMessage("errors.inscription.field.password_1", "Mot de passe"));

		}

		if (StringUtils.length(getMotDePasse()) < 4) {
			errors.add("password2", new ActionMessage("errors.field.minlength", "Mot de passe"));
		}
		
		
		if (StringUtils.isEmpty(getVerifPassword())) {
			errors.add("pass", new ActionMessage("errors.inscription.field.password_2", "Mot de passe à nouveau"));

		}
		
		if (getMotDePasse() != getVerifPassword() || getVerifPassword() != getMotDePasse()) {
			errors.add("pwd", new ActionMessage("errors.inscription.field.verifpassword", "Mot de passe & Mot de passe à nouveau"));

		}
		
		if (StringUtils.isEmpty(getNaissance())) {
			errors.add("naissance", new ActionMessage("errors.inscription.field.naissance", "Date de naissance"));

		}
		
		
		if (StringUtils.isEmpty(getEmail())) {
			errors.add("email", new ActionMessage("errors.field.empty_email", "Adresse email"));

		}
		
		
		
		
		 // va récupéré le nom de l'utilisateur inscrit dans le formulaire
		//request.getSession().setAttribute("utilisateur", this);

		return errors;
	}
	
	
}
