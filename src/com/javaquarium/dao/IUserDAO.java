package com.javaquarium.dao;

import java.util.List;

import com.javaquarium.beans.data.UserDO;

/**
 * 
 * @author alex User data access
 *
 */
public interface IUserDAO {

	/**
	 * @return liste de tout les utilisateurs
	 */
	List<UserDO> getAllUser();

	/**
	 * @param name
	 * retourne un utilisateur en fonction de son nom
	 * @return
	 */
	UserDO find(String name);

	/**
	 * @param u
	 * sauvegarde un utilisateur en base
	 */
	void insert(UserDO utilisateur);

}
