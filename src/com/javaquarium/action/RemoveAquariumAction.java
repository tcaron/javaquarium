package com.javaquarium.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.business.IPoissonService;
import com.javaquarium.business.IUserAquariumService;
import com.javaquarium.util.ConstantsUtils;

public class RemoveAquariumAction extends Action {
	private IPoissonService poissonService;
	private IUserAquariumService userAquariumService;

	@SuppressWarnings("deprecation")
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		final Integer poisson_id = Integer.parseInt(req.getParameter(ConstantsUtils.POISSON_ID));
		final PoissonDO poisson = poissonService.find(poisson_id);

		@SuppressWarnings("unchecked")
		List<PoissonDO> list = (List<PoissonDO>) req.getSession().getAttribute(ConstantsUtils.AQUARIUM_LIST);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == poisson.getId()) {
				list.remove(i);
				break;
			}
		}

		req.getSession().setAttribute(ConstantsUtils.AQUARIUM_LIST, list);
		req.getSession().setAttribute(ConstantsUtils.AQUARIUM_COUNTER, list.size());

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
