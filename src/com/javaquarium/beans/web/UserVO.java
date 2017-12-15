package com.javaquarium.beans.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


/**
 * @author Alex Classic Action
 */

public class UserVO extends ActionForm {

	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	private String repeatPassword;

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(final String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * @return the repeated password
	 */
	public String getRepeatPassword() {
		return repeatPassword;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setRepeatPassword(final String password) {
		this.repeatPassword = password;
	}

	
	@Override
	public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
		final ActionErrors errors = new ActionErrors();

		if (StringUtils.isEmpty(getLogin())) {
			errors.add("nom", new ActionMessage("errors.inscription.field.nom", "Nom"));
		}
		
		if (getLogin().length() < 4){
			errors.add("nom", new ActionMessage("errors.inscription.field.limitnom", "Nom"));
		}
		
		if (StringUtils.isEmpty(getPassword())) {
			errors.add("mot de passe", new ActionMessage("errors.inscription.field.password", "Mot de passe"));
		}	
		
		if (StringUtils.isEmpty(getRepeatPassword())) {
			errors.add("mot de passe", new ActionMessage("errors.inscription.field.password", "Mot de passe à nouveau"));
		}
		
		if (getPassword().length() < 4) {
			errors.add("mot de passe", new ActionMessage("errors.inscription.field.limitpassword", "Mot de passe"));
		}
		
		if (getPassword().compareTo(getRepeatPassword()) != 0) {
			errors.add("mot de passe", new ActionMessage("errors.inscription.field.repeat", "Mot de passe"));
		}
		
		return errors;
	}
}
