package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.hibernate.exception.ConstraintViolationException;

import com.javaquarium.beans.web.UserVO;
import com.javaquarium.business.IUserService;

/**
 * @author Alex Classic Action
 */

public class InscriptionAction extends Action {

	
	private static final String FW_SUCCESS = "success";
    private  IUserService utilisateurService ; 
	@SuppressWarnings("deprecation")
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req, final HttpServletResponse res) {

		UserVO utilisateur = (UserVO)form ;
		
		try {
			utilisateurService.save(utilisateur);
		} catch(ConstraintViolationException e) {
			ActionErrors errors = new ActionErrors();
			errors.add("utilisateur_unique", new ActionMessage("error.name.utilisateur_unique"));
			saveErrors(req, errors);
			return mapping.getInputForward();
		}
		return mapping.findForward(FW_SUCCESS);
	}

	/**
	 * @param UserService
	 *            the UserService to set
	 */
	public void setUserService(IUserService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}
}
