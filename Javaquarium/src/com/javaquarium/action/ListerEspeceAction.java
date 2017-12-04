package com.javaquarium.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.business.IPoissonService;

/**
 * @author Alex Classic Action
 */
public class ListerEspeceAction extends Action {

	private static final String FW_SUCCESS = "success";
	public static final String SESSION_REQUEST = "requestTableauPoisson";
	private IPoissonService poissonService;

	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		final List<PoissonVO> poissonVO = poissonService.findAll();

		req.getSession().setAttribute(SESSION_REQUEST, poissonVO);

		return mapping.findForward(FW_SUCCESS);

	}

	/**
	 * @param poissonService
	 *            the poissonService to set
	 */
	public void setPoissonService(IPoissonService poissonService) {
		this.poissonService = poissonService;
	}

}
