/**
 * 
 */
package com.java.json;

import java.util.Map;

/**
 * @author amahajan
 *
 * @written 24-May-2017
 */
public class PushPojo2 {

	private String name;

	private Map<String, Object> payload;

	/**
	 * @return the payload
	 */
	public Map<String, Object> getPayload() {
		return payload;
	}

	/**
	 * @param payload
	 *            the payload to set
	 */
	public void setPayload(Map<String, Object> payload) {
		this.payload = payload;
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

}
