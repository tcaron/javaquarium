package com.javaquarium.beans.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * 
 * @author alex classic VO Crud
 *
 */
public class LoginVO extends ActionForm {

	private static final long serialVersionUID = 1L;
	private String login;
	private String password;

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		final ActionErrors errors = new ActionErrors();

		if (StringUtils.isEmpty(getLogin())) {
			errors.add("utilisateur", new ActionMessage("errors.field.empty", "utilisateur"));
		}

		if (StringUtils.isEmpty(getPassword())) {
			errors.add("password1", new ActionMessage("errors.field.empty", "mot de passe"));

		}

		if (StringUtils.length(getPassword()) < 4) {
			errors.add("password2", new ActionMessage("errors.field.minlength", "mot de passe"));
		}
		return errors;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * set the password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the username
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * set the username
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

}
