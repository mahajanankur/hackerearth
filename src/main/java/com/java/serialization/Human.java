package com.java.serialization;

import java.io.Serializable;

/**
 * 
 */

/**
 * @author amahajan
 * 
 */
public class Human implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int memId = 10;

	/**
	 * @return the memId
	 */
	public int getMemId() {
		return memId;
	}

	/**
	 * @param memId
	 *            the memId to set
	 */
	public void setMemId(int memId) {
		this.memId = memId;
	}

}
