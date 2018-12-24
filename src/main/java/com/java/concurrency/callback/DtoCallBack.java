/**
 * 
 */
package com.java.concurrency.callback;

/**
 * @author ankur.mahajan
 * @written 20-Dec-2018
 */
public class DtoCallBack {

	private String name;

	private String purp;

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

	public DtoCallBack(String name, String purp) {
		super();
		this.name = name;
		this.purp = purp;
	}

	/**
	 * @return the purp
	 */
	public String getPurp() {
		return purp;
	}

	/**
	 * @param purp
	 *            the purp to set
	 */
	public void setPurp(String purp) {
		this.purp = purp;
	}

}
