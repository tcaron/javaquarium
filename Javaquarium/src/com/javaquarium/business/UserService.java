package com.javaquarium.business;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import com.javaquarium.beans.data.UserDO;
import com.javaquarium.beans.web.UserVO;
import com.javaquarium.dao.IUserDAO;
import com.javaquarium.dao.UserDAO;
import com.javaquarium.util.PasswordHashUtils;

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
	public void addUser(UserVO user) {
		UserDO u = this.map(user);
		userDao.addUser(u);
	}


	@Override
	public UserVO map(final UserDO user) {
		UserVO u = null;
		if (user != null) {
			u = new UserVO();
			u.setLogin(user.getLogin());
			u.setPassword(null);
			u.setRepeatPassword(null);
		}
		return u;
	}

	
	@Override
	public UserDO map(UserVO user) {
		UserDO u = null;
		if (user != null) {
			u = new UserDO();
			u.setLogin(user.getLogin());
			try {
				u.setPasswordHash(PasswordHashUtils.createHash(user.getPassword()));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				e.printStackTrace();
			}
		}
		return u;
	}

	
	@Override
	public UserVO getUser(String login) {
		return map(userDao.getUser(login));
	}

	@Override
	public boolean validateLogin(String login, String password) {
		boolean returnVal = false;
		UserDO databaseUser = userDao.getUser(login);
		if (databaseUser != null) {
			try {
				returnVal = PasswordHashUtils.validatePassword(password, databaseUser.getPasswordHash());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				e.printStackTrace();
			}
		}
		return returnVal;
	}

}
