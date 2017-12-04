package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.business.IPoissonService;

/**
 * @author Alex Classic Action
 */
public class RemoveAction extends Action {

	private static final String FW_SUCCESS = "success";
	private IPoissonService poissonService;
	private static final String PARAM_CODE = "code";

	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		final Integer code = Integer.parseInt(req.getParameter(PARAM_CODE));

		poissonService.delete(code);

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
