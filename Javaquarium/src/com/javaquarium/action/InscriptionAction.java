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

import com.javaquarium.beans.web.InscriptionVO;
import com.javaquarium.business.IUtilisateurService;

public class InscriptionAction extends Action {
	
	private static final String FW_SUCCESS = "success";
	
	private IUtilisateurService utilisateurservice;

	@SuppressWarnings("deprecation")
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
		
		final InscriptionVO ins = (InscriptionVO)form;
		
		try{
			utilisateurservice.save(ins);
		}catch (ConstraintViolationException e) {
			
			final ActionErrors errors = new ActionErrors();
			errors.add("name_constraint",new ActionMessage("error.name.utilisateur_unique"));
			saveErrors(req, errors);
			return mapping.getInputForward();
		}
		
		return mapping.findForward(FW_SUCCESS);
		
		
	}
		
	public void setIUtilisateurService(IUtilisateurService utilisateurservice){
		this.utilisateurservice = utilisateurservice;
	}
	
}
