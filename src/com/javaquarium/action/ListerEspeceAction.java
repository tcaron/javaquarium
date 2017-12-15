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
import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.business.IPoissonService;
import com.javaquarium.business.IUserAquariumService;
import com.javaquarium.business.IUserService;

/**
 * @author Alex Classic Action
 */
public class ListerEspeceAction extends Action {

	private static final String FW_SUCCESS = "success";
	public static final String SESSION_REQUEST = "requestTableauPoisson";
	private static final String REQ_USER = "user";
	private static final String REQ_USER_DO = "user_do";
	private static final String AQUARIUM_COUNTER = "aquarium_size";
	private static final String AQUARIUM_LIST = "aquarium_list";
	private IPoissonService poissonService;
	private IUserService utilisateurService;
	private IUserAquariumService userAquariumService;

	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		final List<PoissonVO> poissonVO = poissonService.findAll();

		req.getSession().setAttribute(SESSION_REQUEST, poissonVO);
		
		List<PoissonDO> list = userAquariumService.getUserAquarium((UserDO) req.getSession().getAttribute(REQ_USER_DO));
		
		if ( req.getSession().getAttribute(AQUARIUM_LIST) == null){
		req.getSession().setAttribute(AQUARIUM_LIST, list);
		req.getSession().setAttribute(AQUARIUM_COUNTER, list.size());
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

	/**
	 * @param UserService
	 *            the UserService to set
	 */
	public void setUserService(IUserService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	/**
	 * @param UserService
	 *            the UserService to set
	 */
	public void setUserAquariumService(IUserAquariumService userAquariumService) {
		this.userAquariumService = userAquariumService;
	}
}
