package com.javaquarium.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javaquarium.beans.data.UserDO;
import com.javaquarium.util.HibernateUtils;

/**
 * @author Alex Classic Action
 */

public class UserDAO implements IUserDAO {

	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserDO> getAllUser() {
		Session session = HibernateUtils.getSession();
		try {
			Query req = session.createQuery("from UserDO");
			return (List<UserDO>) req.list();
		} finally {
			session.close();
		}
	}

	
	@Override
	public UserDO find(String login) {
		Session session = HibernateUtils.getSession();
		UserDO user ;
		try {
			Query req = session.createQuery("from UserDO where login= :username");
			req.setString("username", login);
			user = (UserDO) req.uniqueResult();
		} finally {
			session.close();
		}
		return user;
	}


	@Override
	public void insert(UserDO utilisateur) {
		Session session = HibernateUtils.getSession();

		try {
			Transaction transact = session.beginTransaction();
			session.save(utilisateur);
			transact.commit();
		}
		 finally {
			session.close();
		}
	}

}
