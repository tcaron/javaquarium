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
import com.javaquarium.business.IUserService;
import com.javaquarium.util.ConstantsUtils;

public class SaveAquariumAction extends Action {
	private IUserAquariumService userAquariumService;
	private IPoissonService poissonService;
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		@SuppressWarnings("unchecked")
		List<PoissonDO> list = (List<PoissonDO>)req.getSession().getAttribute(ConstantsUtils.AQUARIUM_LIST);
		List<PoissonDO> list2 = list;
		userAquariumService.save((UserDO) req.getSession().getAttribute(ConstantsUtils.REQ_USER_DO), list2);
		req.getSession().setAttribute(ConstantsUtils.AQUARIUM_LIST, list2);
		req.getSession().setAttribute(ConstantsUtils.AQUARIUM_COUNTER, list2.size());
		
		return mapping.findForward(ConstantsUtils.FW_SUCCESS);

	}
	
	/**
	 * @param UserService
	 *            the UserService to set
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
