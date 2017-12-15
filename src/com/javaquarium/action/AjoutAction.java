package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.hibernate.exception.ConstraintViolationException;

import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.business.IPoissonService;

/**
 * @author Alex Classic Action
 */
public class AjoutAction extends Action {

	private static final String FW_SUCCESS = "success";

	private IPoissonService poissonService;

	@SuppressWarnings("deprecation")
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
		final PoissonVO p = (PoissonVO) form;
		try {
		poissonService.save(p);
		
		}
		catch(ConstraintViolationException e){
			final ActionErrors errors = new ActionErrors();
			errors.add("name_constraint",new ActionMessage("error.name.unique"));
			saveErrors(req, errors);
			return mapping.getInputForward();
		}
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