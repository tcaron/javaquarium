package com.javaquarium.dao;

import java.util.List;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.data.UserDO;

/**
 * 
 * @author alex UserAquarium data access
 *
 */
public interface IUserAquariumDAO {

	/**
	 * retourne la liste des poissons dans l'aquarium de l'utilisateur
	 * 
	 * @param user
	 * @return
	 */
	List<PoissonDO> list(UserDO user);

	/**
	 * vide l'aquarium de l'utilisateur
	 * 
	 * @param user
	 */
	void deleteAquarium(UserDO user);

	/**
	 * sauvegarde l'aquarium de l'utilisateur
	 * 
	 * @param user
	 * @param list
	 */
	void saveAquarium(UserDO user, List<PoissonDO> list);
}
