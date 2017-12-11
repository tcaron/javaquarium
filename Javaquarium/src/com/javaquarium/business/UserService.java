package com.javaquarium.business;


import java.util.ArrayList;
import java.util.List;

import com.javaquarium.beans.data.UserDO;
import com.javaquarium.beans.web.UserVO;
import com.javaquarium.dao.IUserDAO;
import com.javaquarium.dao.UserDAO;

/**
 * @author Alex Classic Action
 */
public class UserService implements IUserService {

	private IUserDAO userDao;

	
	public UserService() {
		userDao = new UserDAO();
	}

	
	@Override
	public List<UserVO> getAllUser() {
		final List<UserDO> listUser = userDao.getAllUser();
		List<UserVO> users = new ArrayList<UserVO>(listUser.size());
		for (final UserDO user : listUser) {
			users.add(map(user));
		}
		return users;
	}

	
	@Override
	public void save(UserVO user) {
		UserDO u = this.map(user);
		userDao.insert(u);
	}


	@Override
	public UserVO map(final UserDO user) {
		final UserVO userVO = new UserVO();
		userVO.setLogin(user.getLogin());
		userVO.setPassword(user.getPassword());
		userVO.setRepeatPassword("");
	
		return userVO;
	}

	
	@Override
	public UserDO map(final UserVO user) {
		final UserDO userDO = new UserDO();
	
		userDO.setLogin(user.getLogin());
		userDO.setPassword(user.getPassword());
	
		return userDO;
	}

	
	@Override
	public UserVO getUser(String login) {
		return map(userDao.getUser(login));
	}

	
	/**
	 * setter userDao
	 * 
	 * @param userDao
	 */
	public void setUserDAO(IUserDAO userDao) {
		this.userDao = userDao;
	}


	@Override
	public boolean validateLogin(String user) {
		UserDO databaseUser = userDao.getUser(user);
	    if (databaseUser != null){
	    	return true;
	    } else {
	    	return false;
	    }
	
		
	}
	
}
