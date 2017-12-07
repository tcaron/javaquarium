package com.javaquarium.beans.data;

import javax.persistence.*;

@Entity
@Table(name = "Utilisateur")
public class UtilisateurDO {

	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "utilisateur",nullable = false, unique = true)
	    private String utilisateur;

	    @Column(name = "motdepasse", nullable = false)
	    private String motDePasse;  
	    
	    public UtilisateurDO(){}
	    
	    public Integer getId() {
	        return id;
	    }
	    
	    public String getUtilisateur() {
	    	return utilisateur;
	    }
 
	    public void setUtilisateur(String utilisateur) {
	    	this.utilisateur =utilisateur;
	    }

	    public String getMotDePasse() {
	    	return motDePasse;
	    }
	 
	    public void setMotDePasse(String motDePasse) {
	    	this.motDePasse = motDePasse;
	    }
	    
	}
	
