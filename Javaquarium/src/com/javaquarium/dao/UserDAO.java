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
	public UserDO getUser(String login) {
		Session session = HibernateUtils.getSession();
		UserDO util = null;
		try {
			Query req = session.createQuery("from UserDO where login= :myLogin");
			req.setString("myLogin", login);
			util = (UserDO) req.uniqueResult();
			System.out.println("erreur");
			System.exit(0);
		} finally {
			session.close();
		}
		return util;
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
