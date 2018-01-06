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
import com.javaquarium.business.IPoissonService;
import com.javaquarium.business.IUserAquariumService;
import com.javaquarium.util.ConstantsUtils;

public class SaveAquariumAction extends Action {
	private IUserAquariumService userAquariumService;
	private IPoissonService poissonService;

	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		try {
			@SuppressWarnings("unchecked")
			List<PoissonDO> list = (List<PoissonDO>) req.getSession().getAttribute(ConstantsUtils.AQUARIUM_LIST);
			userAquariumService.save((UserDO) req.getSession().getAttribute(ConstantsUtils.REQ_USER_DO), list);
			req.getSession().setAttribute(ConstantsUtils.AQUARIUM_LIST, list);
			req.getSession().setAttribute(ConstantsUtils.AQUARIUM_COUNTER, list.size());
		} catch (ClassCastException e) {
			return mapping.findForward(ConstantsUtils.FW_ERROR);
		}

		return mapping.findForward(ConstantsUtils.FW_SUCCESS);

	}

	/**
	 * @param UserAquariumService
	 *            the UserAquariumService to set
	 */
	public void setUserAquariumService(IUserAquariumService userAquariumService) {
		this.userAquariumService = userAquariumService;
	}

	/**
	 * @param poissonService
	 *            the poissonService to set
	 */
	public void setPoissonService(IPoissonService poissonService) {
		this.poissonService = poissonService;
	}
}
