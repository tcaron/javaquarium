package com.javaquarium.business;

import java.util.List;

import com.javaquarium.beans.data.UserDO;
import com.javaquarium.beans.web.UserVO;

/**
 * @author Alex Classic Action
 */
public interface IUserService {

	
	List<UserVO> getAllUser();

	
	UserDO map(UserVO user);

	
	UserVO map(UserDO user);

	
	void addUser(UserVO user);

	
	UserVO getUser(String login);

	
	boolean validateLogin(String login, String password);
}
