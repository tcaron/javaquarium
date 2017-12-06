package com.javaquarium.beans.data;

import javax.persistence.*;

@Entity
@Table(name = "Utilisateur")
public class UtilisateurDO {

	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "utilisateur", unique = true)
	    private String utilisateur;

	    @Column(name = "motdepasse")
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

	    public String getMotdepasse() {
	    	return motDePasse;
	    }
	 
	    public void setPassword(String motDePasse) {
	    	this.motDePasse = motDePasse;
	    }
	    
	}
	
