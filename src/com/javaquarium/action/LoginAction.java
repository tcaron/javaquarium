package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.javaquarium.beans.web.LoginVO;
import com.javaquarium.beans.web.UserVO;
import com.javaquarium.business.IUserService;
import com.javaquarium.util.ConstantsUtils;

/**
 * @author Alex Classic Action
 */
public class LoginAction extends Action {

	private IUserService utilisateurService;

	@SuppressWarnings("deprecation")
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		LoginVO user = (LoginVO) form;
		ActionErrors errors = new ActionErrors();
		if (req.getSession().getAttribute(ConstantsUtils.REQ_USER) != null) {
			req.getSession().invalidate();
		}

		try {
			UserVO userLogin = utilisateurService.getUser(user.getLogin());

			if (!userLogin.getPassword().equals(user.getPassword())) {
				errors.add("wrong_password", new ActionMessage("error.login.wrong_password"));
				saveErrors(req, errors);
				return mapping.findForward(ConstantsUtils.FW_ERROR);
			} else
				req.getSession().setAttribute(ConstantsUtils.REQ_USER, user.getLogin());
			req.getSession().setAttribute(ConstantsUtils.REQ_USER_DO, utilisateurService.map(userLogin));
		}

		catch (NullPointerException e) {
			errors.add("unknow_user", new ActionMessage("error.login.unknow_user"));
			saveErrors(req, errors);
			return mapping.findForward(ConstantsUtils.FW_ERROR);
		}

		return mapping.findForward(ConstantsUtils.FW_SUCCESS);

	}

	/**
	 * @param UserService
	 *            the UserService to set
	 */
	public void setUserService(IUserService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

}
