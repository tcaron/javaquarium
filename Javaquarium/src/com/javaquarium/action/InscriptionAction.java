package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.javaquarium.business.IPoissonService;
import com.javaquarium.business.IUserService;
import com.javaquarium.business.UserService;
import com.javaquarium.beans.web.UserVO;

/**
 * @author Alex Classic Action
 */

public class InscriptionAction extends Action {

	
	private static final String FW_SUCCESS = "success";
	private static final String FW_FORM_ERROR = "form_error";
    private  IUserService utilisateurService ; 
	@SuppressWarnings("deprecation")
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req, final HttpServletResponse res) {

		String forward = FW_SUCCESS;
		UserVO utilisateur = utilisateurService.getUser(((UserVO)form).getLogin());
		
		if (utilisateur == null) {
			utilisateurService.addUser((UserVO)form);
		} else {
			ActionErrors errors = new ActionErrors();
			errors.add("utilisateur_unique", new ActionMessage("error.name.utilisateur_unique"));
			saveErrors(req, errors);
			forward = FW_FORM_ERROR;
		}
		return mapping.findForward(forward);
	}

	/**
	 * @param poissonService
	 *            the poissonService to set
	 */
	public void setUserService(IUserService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}
}
