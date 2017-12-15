package com.javaquarium.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.data.UserDO;
import com.javaquarium.business.IUserAquariumService;
import com.javaquarium.util.ConstantsUtils;

public class EmptyAquariumAction extends Action {

	private IUserAquariumService userAquariumService;

	@SuppressWarnings("deprecation")
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		try {
			
			userAquariumService.emptyAquarium((UserDO) req.getSession().getAttribute(ConstantsUtils.REQ_USER_DO));
			@SuppressWarnings("unchecked")
			List<PoissonDO> list = (List<PoissonDO>)req.getSession().getAttribute(ConstantsUtils.AQUARIUM_LIST);
			list.clear();
			req.getSession().setAttribute(ConstantsUtils.AQUARIUM_LIST, list);
			req.getSession().setAttribute(ConstantsUtils.AQUARIUM_COUNTER, list.size());
			
		} catch (NullPointerException e) {

			return mapping.findForward(ConstantsUtils.FW_ERROR);
		}
		return mapping.findForward(ConstantsUtils.FW_SUCCESS);

	}

	/**
	 * @param UserService
	 *            the UserService to set
	 */
	public void setUserAquariumService(IUserAquariumService userAquariumService) {
		this.userAquariumService = userAquariumService;
	}
}
