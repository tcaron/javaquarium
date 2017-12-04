package com.javaquarium.beans.web;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

/**
 * 
 * @author alex
 *
 */
public class PoissonVO extends ActionForm {

	public static final String SEPARATOR_POISSON = "x";
	
	private static final long serialVersionUID = -123456789L;
	private Integer code;
	private String espece;
	private String description;
	private String couleur;
	private String dimension;
	private Integer prix;
	private String nom;

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the espece
	 */
	public String getEspece() {
		return espece;
	}

	/**
	 * @param espece
	 *            the espece to set
	 */
	public void setEspece(String espece) {
		this.espece = espece;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

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
	 * @return the dimension
	 */
	public String getDimension() {
		return dimension;
	}

	/**
	 * @param dimension
	 *            the dimension to set
	 */
	public void setDimension(String dimension) {
		this.dimension = dimension;
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

	public PoissonVO() {
	}

	public PoissonVO(String nom, String espece, String description, String couleur, String dimension, Integer prix) {
		this.espece = espece;
		this.description = description;
		this.couleur = couleur;
		this.dimension = dimension;
		this.prix = prix;
		this.nom = nom;
	}

	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
		
			final ActionErrors errors = new ActionErrors();
		
		if(StringUtils.isEmpty(getNom())){
			errors.add("nom", new ActionMessage("errors.field.nom", "nom"));
		}
		
		if(StringUtils.isEmpty(getDescription())){
			errors.add("description", new ActionMessage("errors.field.description", "description"));
		}
		
		if(StringUtils.isEmpty(getCouleur())){
			errors.add("couleur", new ActionMessage("errors.field.couleur", "couleur"));
		}
		
		if(StringUtils.isEmpty(getPrix().toString())){
			errors.add("prix", new ActionMessage("errors.field.prix", "prix"));
		}
		
		if (!getDimension().matches("[0-9]+x[0-9]+$"))
		{
			errors.add("dimension_regex", new ActionMessage("errors.field.match_dimension", "dimension_regex"));
		}
		
		if (StringUtils.isEmpty(getDimension().toString())){
			errors.add("dimension", new ActionMessage("errors.field.empty_dimension", "dimension"));
			
		}
		return errors;
		
	}
}
