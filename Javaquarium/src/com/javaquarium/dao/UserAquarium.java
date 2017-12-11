package com.javaquarium.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.data.UserAquariumDO;
import com.javaquarium.util.HibernateUtils;

public class UserAquarium implements IUserAquariumDAO {

	@Override
	public void addPoisson(UserAquariumDO userAquarium) {
	final Session s = HibernateUtils.getSession();
		
		try {
			final Transaction t = s.beginTransaction();
			s.save(userAquarium);
			t.commit();
		} 
		
		finally {
			s.close();
		}

		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAquariumDO> getAquarium(String login) {
		final Session s = HibernateUtils.getSession();
		final Transaction tx = s.beginTransaction();
		final Query q = s.createQuery("from UserAquariumDO");
		
		@SuppressWarnings("rawtypes")
		final List<UserAquariumDO> list = (List) q.list();

		tx.commit();
		s.close();

		return list;

	}

	@Override
	public void remove(String login) {
		// TODO Auto-generated method stub
		
	}
	
	

}
