package com.javaquarium.beans.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "poisson")

public class PoissonDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "couleur", nullable = false)
	private String couleur;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "largeur", nullable = false)
	private float largeur;

	@Column(name = "longueur", nullable = false)
	private float longueur;

	@Column(name = "nom", nullable = false, unique = true)
	private String nom;

	@Column(name = "prix", nullable = false)
	private Integer prix;

	/**
	 * @return the couleur
	 */
	public String getCouleur() {
		return couleur;
	}

	/**
	 * @param couleur
	 *            the couleur to set
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param descritpion
	 *            the descritpion to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the largeur
	 */
	public float getLargeur() {
		return largeur;
	}

	/**
	 * @param largeur
	 *            the largeur to set
	 */
	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}

	/**
	 * @return the longeur
	 */
	public float getLongueur() {
		return longueur;
	}

	/**
	 * @param longeur
	 *            the longeur to set
	 */
	public void setLongeur(float longueur) {
		this.longueur = longueur;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prix
	 */
	public Integer getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	public PoissonDO() {
	}

}