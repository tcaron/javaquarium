package com.javaquarium.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.data.UserAquariumDO;
import com.javaquarium.beans.data.UserDO;
import com.javaquarium.util.HibernateUtils;

public class UserAquariumDAO implements IUserAquariumDAO {

	public List<PoissonDO> list(UserDO user) {

		final Session s = HibernateUtils.getSession();
		final Transaction t = s.beginTransaction();
		final IUserDAO userDAO = new UserDAO();
		user = userDAO.find(user.getLogin());
		final Query q = s.createQuery("from UserAquariumDO where user=:user");
		q.setParameter("user", user);

		@SuppressWarnings("rawtypes")
		final List<PoissonDO> list = (List) q.list();

		t.commit();
		s.close();

		return list;

	}

	@Override
	public void deleteAquarium(UserDO user) {
		final Session s = HibernateUtils.getSession();
		final Transaction t = s.beginTransaction();
		final IUserDAO userDAO = new UserDAO();
		user = userDAO.find(user.getLogin());
		final Query q = s.createQuery("delete UserAquariumDO where user=:user");
		q.setParameter("user", user);

		try {

			q.executeUpdate();

			t.commit();

		} finally {

			s.close();
		}
	}

	@Override
	public void saveAquarium(UserDO user, List<PoissonDO> list) {
		final Session s = HibernateUtils.getSession();
		final Transaction t = s.beginTransaction();
		final IUserDAO userDAO = new UserDAO();
		 
		user = userDAO.find(user.getLogin());
		try {
			deleteAquarium(user);
			for(PoissonDO poisson : list){
				final UserAquariumDO userAquariumDO = new UserAquariumDO();
				userAquariumDO.setUser(user);
				userAquariumDO.setPoisson(poisson);
				System.out.println(poisson);
				s.merge(userAquariumDO);
				
			}
			
			t.commit();
		}
		
		finally{
			s.close();
		}
		
	}
}
