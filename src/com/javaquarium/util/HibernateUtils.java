package com.javaquarium.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Unique point d'acc�s � la base de donn�es via {@link Session}.
 * 
 * Recommand� par l'�quipe Hibernate
 * 
 * @author Max
 * 
 */
@SuppressWarnings("deprecation")
public class HibernateUtils {

	// Singleton
	private static final SessionFactory sessionFactory;

	// Cr�e une unique instance de la SessionFactory � partir de
	// hibernate.cfg.xml
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException ex) {
			throw new RuntimeException("Probl�me de configuration : " + ex.getMessage(), ex);
		}
	}

	// Retourne la session Hibernate (singleton)
	public static Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}
}