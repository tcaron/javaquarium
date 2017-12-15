package com.javaquarium.dao;

import java.util.List;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.data.UserDO;

public interface IUserAquariumDAO  {
	List<PoissonDO> list(UserDO user);
	
	void deleteAquarium (UserDO user);
	
	void saveAquarium (UserDO user, List<PoissonDO> list);
}
