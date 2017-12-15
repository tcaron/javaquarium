package com.javaquarium.business;

import java.util.List;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.data.UserDO;
import com.javaquarium.dao.IUserAquariumDAO;
import com.javaquarium.dao.UserAquariumDAO;

public class UserAquariumService implements IUserAquariumService {

	private IUserAquariumDAO aquariumDAO;

	@Override
	public List<PoissonDO> getUserAquarium(UserDO user) {
	
		 return aquariumDAO.list(user);
	
	}

	public UserAquariumService() {
		aquariumDAO = new UserAquariumDAO();
	}

	/**
	 * setter PoissonDAO
	 * 
	 * @param poissonDAO
	 */
	public void setUserAquariumDAO(IUserAquariumDAO aquariumDAO) {
		this.aquariumDAO = aquariumDAO;
	}

	@Override
	public void addPoissonAquarium(List<PoissonDO> list, PoissonDO poisson) {
		list.add(poisson);	
	}

	@Override
	public void save(UserDO user, List<PoissonDO> list) {
		aquariumDAO.saveAquarium(user, list);	
	}

	@Override
	public void emptyAquarium(UserDO user) {
		aquariumDAO.deleteAquarium(user);	
	}

	@Override
	public void removePoissonAquarium(List<PoissonDO> list,PoissonDO poisson) {
		// TODO Auto-generated method stub
		
	}

	
}
