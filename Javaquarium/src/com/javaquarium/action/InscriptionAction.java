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

import com.javaquarium.beans.web.UtilisateurVO;
import com.javaquarium.business.IUtilisateurService;
import com.javaquarium.business.UtilisateurService;

public class InscriptionAction extends Action {
	
	private static final String FW_SUCCESS = "success";
	


	@SuppressWarnings("deprecation")
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
	   UtilisateurService utilisateurService = new UtilisateurService();
		final UtilisateurVO user = (UtilisateurVO) form;
		
		
		try {
			utilisateurService.save(user);
		}
		catch (Exception e){
			 System.out.println("fail2");
		}
	
		
		return mapping.findForward(FW_SUCCESS);
			
	}
	
	
}
