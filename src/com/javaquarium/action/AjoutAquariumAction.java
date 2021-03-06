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
import com.javaquarium.util.ConstantsUtils;

/**
 * @author Thomas, ajout d'un poisson � la liste de l'aquarium utilisateur
 */
public class AjoutAquariumAction extends Action {

	private IPoissonService poissonService;

	@SuppressWarnings("deprecation")
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		if (req.getSession().getAttribute(ConstantsUtils.REQ_USER_DO) == null) {
			return mapping.findForward(ConstantsUtils.FW_ERROR);
		}

		final Integer poisson_id = Integer.parseInt(req.getParameter(ConstantsUtils.POISSON_ID));
		final PoissonDO poisson = poissonService.find(poisson_id);

		@SuppressWarnings("unchecked")
		List<PoissonDO> list = (List<PoissonDO>) req.getSession().getAttribute(ConstantsUtils.AQUARIUM_LIST);
		list.add(poisson);
		req.getSession().setAttribute(ConstantsUtils.AQUARIUM_LIST, list);
		req.getSession().setAttribute(ConstantsUtils.AQUARIUM_COUNTER, list.size());

		return mapping.findForward(ConstantsUtils.FW_SUCCESS);

	}

	/**
	 * @param poissonService
	 *            the poissonService to set
	 */
	public void setPoissonService(IPoissonService poissonService) {
		this.poissonService = poissonService;
	}
}
