/**
 * 
 */
package com.java.collection.map;

/**
 * @author amahajan
 *
 * @written Jun 2, 2016
 */
public class Person {

	private int pId;

	private String name;

	public Person(int pId, String name) {
		super();
		this.pId = pId;
		this.name = name;
	}

	public Person() {
	}

	/**
	 * @return the pId
	 */
	public int getpId() {
		return pId;
	}

	/**
	 * @param pId
	 *            the pId to set
	 */
	public void setpId(int pId) {
		this.pId = pId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pId != other.pId)
			return false;
		return true;
	}

	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// result = prime * result + ((name == null) ? 0 : name.hashCode());
	// result = prime * result + pId;
	// return result;
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// Person other = (Person) obj;
	// if (name == null) {
	// if (other.name != null)
	// return false;
	// } else if (!name.equals(other.name))
	// return false;
	// if (pId != other.pId)
	// return false;
	// return true;
	// }

	// @Override
	// public boolean equals(Object obj) {
	// return false;
	// }
	//
	// @Override
	// public int hashCode() {
	// return 1;
	// }

}
