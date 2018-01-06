package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.util.ConstantsUtils;

/**
 * @author Alex Classic Action Deconnexion
 */
public class LogoutAction extends Action {

	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		req.getSession().invalidate();
		return mapping.findForward(ConstantsUtils.FW_SUCCESS);
	}

}