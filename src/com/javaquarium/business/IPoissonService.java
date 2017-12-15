package com.javaquarium.business;

import java.util.List;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.web.PoissonVO;

/**
 * 
 * @author alex
 *
 */
public interface IPoissonService {

	/**
	 * Classic CRUD
	 * 
	 * @return
	 */
	List<PoissonVO> findAll();

	/**
	 * Classic CRUD
	 * 
	 * @param id
	 */
	PoissonDO find(Integer id);

	/**
	 * Classic CRUD
	 * 
	 * @param poissonvo
	 */
	void save(PoissonVO poissonvo);

	/**
	 * Classic CRUD
	 * 
	 * @param code
	 */
	void delete(Integer code);

}
