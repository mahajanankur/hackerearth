/**
 * 
 */
package com.java.snarios;

/**
 * @author amahajan
 *
 * @written Sep 28, 2016
 */
public class ImpinjDTO {

	private String zone;

	private String floor;

	private String sku;

	private String name;

	private boolean isExecuted;

	/**
	 * @return the isExecuted
	 */
	public boolean isExecuted() {
		return isExecuted;
	}

	/**
	 * @param isExecuted
	 *            the isExecuted to set
	 */
	public void setExecuted(boolean isExecuted) {
		this.isExecuted = isExecuted;
	}

	/**
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}

	/**
	 * @param zone
	 *            the zone to set
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}

	/**
	 * @return the floor
	 */
	public String getFloor() {
		return floor;
	}

	/**
	 * @param floor
	 *            the floor to set
	 */
	public void setFloor(String floor) {
		this.floor = floor;
	}

	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @param sku
	 *            the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
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
	 * @param zone
	 * @param floor
	 * @param sku
	 * @param name
	 */
	public ImpinjDTO(String zone, String floor, String sku, String name, boolean isExecuted) {
		super();
		this.zone = zone;
		this.floor = floor;
		this.sku = sku;
		this.name = name;
		this.isExecuted = isExecuted;
	}

	public ImpinjDTO(String zone, String floor, String sku, String name) {
		super();
		this.zone = zone;
		this.floor = floor;
		this.sku = sku;
		this.name = name;
	}

}
