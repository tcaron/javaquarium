package com.javaquarium.business;

import java.util.List;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.data.UserDO;

public interface IUserAquariumService {

	List<PoissonDO> getUserAquarium(UserDO user);

	void addPoissonAquarium(List<PoissonDO> list, PoissonDO poisson);

	void save(UserDO user, List<PoissonDO> list);

	void emptyAquarium(UserDO user);

	void removePoissonAquarium(List<PoissonDO> list, PoissonDO poisson);
}
