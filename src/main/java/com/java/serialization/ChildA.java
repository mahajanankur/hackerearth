package com.java.serialization;

import java.io.Serializable;

/**
 * 
 */

/**
 * @author amahajan
 * 
 */
public class ChildA extends Parent implements Serializable {

	private static final long serialVersionUID = 1L;

	String name;

	public ChildA(int id, String name) {
		super(id);
		this.name = name;
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

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChildA [name=" + name + "]";
	}
}
