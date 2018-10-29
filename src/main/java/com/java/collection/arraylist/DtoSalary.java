/**
 * 
 */
package com.java.collection.arraylist;

/**
 * @author ankur.mahajan
 * @written 16-Oct-2018
 */
public class DtoSalary {

	private Long id;

	private Double salaryAmount;

	private Long assignmentId;

	public DtoSalary(Long id, Double salaryAmount, Long assignmentId) {
		super();
		this.id = id;
		this.salaryAmount = salaryAmount;
		this.assignmentId = assignmentId;
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
	 * @return the salaryAmount
	 */
	public Double getSalaryAmount() {
		return salaryAmount;
	}

	/**
	 * @param salaryAmount
	 *            the salaryAmount to set
	 */
	public void setSalaryAmount(Double salaryAmount) {
		this.salaryAmount = salaryAmount;
	}

	/**
	 * @return the assignmentId
	 */
	public Long getAssignmentId() {
		return assignmentId;
	}

	/**
	 * @param assignmentId
	 *            the assignmentId to set
	 */
	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
	}

}
