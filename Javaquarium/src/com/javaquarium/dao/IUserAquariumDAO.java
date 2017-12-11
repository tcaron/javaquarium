package com.javaquarium.dao;

import com.javaquarium.beans.data.UserAquariumDO;
import java.util.List;
public interface IUserAquariumDAO {
	
	void addPoisson (final UserAquariumDO userAquarium);

	List<UserAquariumDO> getAquarium(final String login);
	
	void remove (final String login);
	
}
