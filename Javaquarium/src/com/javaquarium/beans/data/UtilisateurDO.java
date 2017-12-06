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
	    
	    @Column(name = "verification_motdepasse")
	    private String motDePasse2;
	    
	    @Column(name = "email")
	    private String email;
	    	    
	    
	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id; 
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
	    
	    public String getEmail(){
	    	return email;
	    }
	    
	    public void setEmail(String email){
	    	this.email = email;
	    }
	    
	  
	    public String getVerifMotDePasse(){
	    	return motDePasse2;
	    }
	    
	    public void SetVerifMotDePasse(String motDePasse2){
	    	this.motDePasse2 = motDePasse2;
	    }
	    
	}
	
