package com.javaquarium.dao;

/**
 * 
 * @author alex
 *
 */
public interface IUtilisateurDAO {
	
	/*
	 *  On regarde si l'utilisateur existe 
	 */

	boolean Search (String utilisateur, String motdepasse);
	
	
}
