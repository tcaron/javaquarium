package com.javaquarium.dao;

import java.util.List;

import com.javaquarium.beans.data.PoissonDO;

/**
 * 
 * @author alex
 *
 */
public interface IPoissonDAO {

	void insert(PoissonDO poisson);

	void delete(Integer code);

	List<PoissonDO> list();
    
	PoissonDO find (Integer id);
}
