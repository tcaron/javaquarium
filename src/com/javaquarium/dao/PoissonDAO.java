package com.javaquarium.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.data.UserDO;
import com.javaquarium.util.HibernateUtils;

/**
 * 
 * @author alex
 *
 */
public class PoissonDAO implements IPoissonDAO {

	public void insert(PoissonDO poisson) {
		
		final Session s = HibernateUtils.getSession();
		
		try {
			final Transaction t = s.beginTransaction();
			s.save(poisson);
			t.commit();
		} 
		
		finally {
			s.close();
		}

	}

	public void delete(Integer code) {

		final Session s = HibernateUtils.getSession();
		final Transaction t = s.beginTransaction();
		final Query q = s.createQuery("delete PoissonDO WHERE code=:code");
		
		q.setString("code", code.toString());

		try {

			q.executeUpdate();

			t.commit();

		} finally {

			s.close();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PoissonDO> list() {
		
		final Session s = HibernateUtils.getSession();
		final Transaction tx = s.beginTransaction();
		final Query q = s.createQuery("from PoissonDO");
		
		@SuppressWarnings("rawtypes")
		final List<PoissonDO> list = (List) q.list();

		tx.commit();
		s.close();

		return list;

	}

	@Override
	public PoissonDO find(Integer id) {
		Session session = HibernateUtils.getSession();
		PoissonDO poisson ;
		try {
			Query req = session.createQuery("from PoissonDO where id= :id");
			req.setInteger("id", id);
			poisson = (PoissonDO) req.uniqueResult();
		} finally {
			session.close();
		}
		return poisson;
	}
}
