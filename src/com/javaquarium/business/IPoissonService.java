package com.javaquarium.business;

import java.util.List;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.web.PoissonVO;

/**
 * 
 * @author alex Interface pour service Poisson
 *
 */
public interface IPoissonService {

	/**
	 * Liste de tout les poissons
	 * 
	 * @return
	 */
	List<PoissonVO> findAll();

	/**
	 * trouve un poisson en fonction du param
	 * 
	 * @param id
	 * @return
	 */
	PoissonDO find(Integer id);

	/**
	 * sauvegarde un nouveau poisson
	 * 
	 * @param poissonvo
	 */
	void save(PoissonVO poissonvo);

	/**
	 * supprime un poisson en fonction de son id
	 * 
	 * @param code
	 */
	void delete(Integer code);

}
