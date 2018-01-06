package com.javaquarium.business;

import java.util.List;

import com.javaquarium.beans.data.UserDO;
import com.javaquarium.beans.web.UserVO;

/**
 * @author Thomas Interface pour le service utilisateur
 *
 */
public interface IUserService {

	/**
	 * retourne une liste de tout les utilisateurs
	 * 
	 * @return
	 */
	List<UserVO> getAllUser();

	/**
	 * converti un VO en DO
	 * 
	 * @param user
	 * @return
	 */
	UserDO map(UserVO user);

	/**
	 * converti un DO en VO
	 * 
	 * @param user
	 * @return
	 */
	UserVO map(UserDO user);

	/**
	 * sauvegarde un utilisateur
	 * 
	 * @param user
	 */
	void save(UserVO user);

	/**
	 * retourne un utilisateur en fonction de son login
	 * 
	 * @param login
	 * @return
	 */
	UserVO getUser(String login);

}
