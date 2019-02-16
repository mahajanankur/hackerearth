/**
 * 
 */
package com.java.lib.lombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ankur.mahajan
 * @written 16-Feb-2019
 */
@ToString
@EqualsAndHashCode
public class DtoPojo1 {

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	@ToString.Exclude
	private String name;

	@Getter
	@Setter
	@EqualsAndHashCode.Exclude
	private String address;
}
