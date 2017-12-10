package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.beans.web.LoginVO;
import com.javaquarium.business.IUserService;

/**
 * @author Alex Classic Action
 */
public class LoginAction extends Action {

	private static final String FW_SUCCESS = "success";
	private  IUserService utilisateurService ;
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
		
		final LoginVO login = (LoginVO) form; 
		try{
		System.out.println(utilisateurService.getUser(login.getUtilisateur()));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return mapping.findForward(FW_SUCCESS);
	}
	
	/**
		 * @param UserService
		 *            the UserService to set
		 */
		public void setUserService(IUserService utilisateurService) {
			this.utilisateurService = utilisateurService;
		}
		
	
}
