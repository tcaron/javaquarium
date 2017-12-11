package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.javaquarium.beans.web.LoginVO;
import com.javaquarium.business.IPoissonService;
import com.javaquarium.business.IUserService;

/**
 * @author Alex Classic Action
 */
public class LoginAction extends Action {

	private static final String FW_SUCCESS = "SUCCESS";
	private static final String FW_ERROR = "ERROR";
	
	private  IUserService utilisateurService ;
	private IPoissonService poissonService;
	
	
	
	@SuppressWarnings("deprecation")
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
		
		String login = ((LoginVO) form).getUtilisateur();
		String password = ((LoginVO) form).getMotDePasse();
		
		final LoginVO loginVO = (LoginVO) form; 
	
		if (utilisateurService.validateLogin(login,password)){
			
			 req.getSession().setAttribute(ListerEspeceAction.SESSION_REQUEST, loginVO.getUtilisateur());

			 return mapping.findForward(FW_SUCCESS);
			
		}else {
			
			 final ActionErrors errors = new ActionErrors();
			 errors.add("connexion", new ActionMessage("errors.fiels.badlogin"));
			 saveErrors(req, errors);
			 
			 return mapping.findForward(FW_ERROR);
			
		}
	}
	
	/**
		 * @param UserService
		 *            the UserService to set
		 */
		public void setUserService(IUserService utilisateurService) {
			this.utilisateurService = utilisateurService;
		}
		
		public void setPoissonService(IPoissonService poissonService) {
			this.poissonService = poissonService;
		}
}
