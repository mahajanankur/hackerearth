/**
 * 
 */
package com.java.json;

/**
 * @author ankur.mahajan
 * @written 12-Jun-2018
 */
public class DtoContact {

	private Integer contactId;
	private String email;
	private String mobile;
	private String landline;
	private String address;

	/**
	 * @return the contactId
	 */
	public Integer getContactId() {
		return contactId;
	}

	/**
	 * @param contactId
	 *            the contactId to set
	 */
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @return the landline
	 */
	public String getLandline() {
		return landline;
	}

	/**
	 * @param landline
	 *            the landline to set
	 */
	public void setLandline(String landline) {
		this.landline = landline;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}
