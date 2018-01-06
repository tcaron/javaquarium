package com.javaquarium.dao;

import java.util.List;

import com.javaquarium.beans.data.PoissonDO;

/**
 * 
 * @author alex Poisson data access
 *
 */
public interface IPoissonDAO {

	/**
	 * Insert un poisson en base
	 * 
	 * @param poisson
	 */
	void insert(PoissonDO poisson);

	/**
	 * Supprime un Poisson en base
	 * 
	 * @param code
	 */
	void delete(Integer code);

	/**
	 * retourne la liste des poissons
	 * 
	 * @return
	 */
	List<PoissonDO> list();

	/**
	 * retourne un poisson en fonction de son id
	 * 
	 * @param id
	 * @return
	 */
	PoissonDO find(Integer id);
}
