/**
 * 
 */
package com.java.json;

import java.util.List;
import java.util.UUID;

/**
 * @author amahajan
 *
 * @written 24-May-2017
 */
public class PushPojo1 extends PushPojo3 {

	private UUID id;

	private List<String> deviceToken;

	private PushPojo2 data;

	/**
	 * @return the deviceToken
	 */
	public List<String> getDeviceToken() {
		return deviceToken;
	}

	/**
	 * @param deviceToken
	 *            the deviceToken to set
	 */
	public void setDeviceToken(List<String> deviceToken) {
		this.deviceToken = deviceToken;
	}

	/**
	 * @return the data
	 */
	public PushPojo2 getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(PushPojo2 data) {
		this.data = data;
	}

	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}
	
	

}
