package com.javaquarium.beans.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Alex Classic Action
 */

@Entity
@Table(name = "user")
public class UserDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "login", nullable = true)
	private String login;

	@Column(name = "password", nullable = true)
	private String password;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password hash
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param hash the password hash to set
	 */
	public void setPassword(String hash) {
		this.password = hash;
	}

}
