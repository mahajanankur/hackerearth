/**
 * 
 */
package com.java.java8.stream;

import java.util.Date;

/**
 * @author ankur.mahajan
 * @written 30-Oct-2018
 */
public class Entity1 {

	private Long id;

	private String name;

	private String mobile;

	private Date dob;

	public Entity1(Long id, String name, String mobile, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.dob = dob;
	}

	public Entity1() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

}
