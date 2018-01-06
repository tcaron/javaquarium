package com.javaquarium.beans.data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Thomas Classic Data object
 */

@Entity
@Table(name = "user_aquarium")
public class UserAquariumDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user")
	private UserDO user;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "poisson")
	private PoissonDO poisson;

	/**
	 * @return the user
	 */
	public UserDO getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(UserDO user) {
		this.user = user;
	}

	/**
	 * @return the poisson
	 */
	public PoissonDO getPoisson() {
		return poisson;
	}

	/**
	 * @param poisson
	 *            the poisson to set
	 */
	public void setPoisson(PoissonDO poisson) {
		this.poisson = poisson;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

}
