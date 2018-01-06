package com.javaquarium.business;

import java.util.List;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.data.UserDO;

/**
 * @author Thomas Interface pour le service d'aquarium
 *
 */
public interface IUserAquariumService {

	/**
	 * recupére l'aquarium de l'utilisateur
	 * 
	 * @param user
	 * @return
	 */
	List<PoissonDO> getUserAquarium(UserDO user);

	/**
	 * ajoute un poisson dans l'aquarium utilisateur
	 * 
	 * @param list
	 * @param poisson
	 */
	void addPoissonAquarium(List<PoissonDO> list, PoissonDO poisson);

	/**
	 * sauvegardel'aquarium de l'utilisateur
	 * 
	 * @param user
	 * @param list
	 */
	void save(UserDO user, List<PoissonDO> list);

	/**
	 * vide l'aquarium de l'utilisateur en param
	 * 
	 * @param user
	 */
	void emptyAquarium(UserDO user);

	/**
	 * supprime un poisson de l'aquarium utilisateur
	 * 
	 * @param list
	 * @param poisson
	 */
	void removePoissonAquarium(List<PoissonDO> list, PoissonDO poisson);
}
