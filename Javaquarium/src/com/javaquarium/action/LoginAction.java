package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.business.IPoissonService;
import com.javaquarium.business.IUtilisateurService;

/**
 * @author Alex Classic Action
 */
public class LoginAction extends Action {

	private static final String FW_SUCCESS = "success";
 
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		return mapping.findForward(FW_SUCCESS);
	}
	
}
